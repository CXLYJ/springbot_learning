package com.lyj.lucence;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.nio.file.Paths;

/**
 * Created by lyj on 2018/11/1.
 */
public class Searcher {

    /**
     * 从索引中查询某个字段
     * @param indexDir
     * @param q
     * @throws Exception
     */
    public static void search(String indexDir, String q)throws Exception{
        //获取索引需要查询的路径，也就是索引所在的位置
        Directory directory = FSDirectory.open(Paths.get(indexDir));
        //读取索引
        IndexReader reader = DirectoryReader.open(directory);
        //构建IndexSearcher
        IndexSearcher searcher = new IndexSearcher(reader);
        //标准分词器，会自动去掉空格啊，is a the 等单词
        Analyzer analyzer = new StandardAnalyzer();
        //查询解析器
        QueryParser queryParser = new QueryParser("contents",analyzer);
        //通过解析要查询的 String，获取查询对象，q 为传进来的待查的字符串
        Query query =queryParser.parse(q);

        //记录索引开始时间
        long startTime = System.currentTimeMillis();

        //开始查询，查询前10条数据，将记录保存在 docs 中
        TopDocs docs =searcher.search(query,10);

        //记录索引结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("匹配" + q + "共耗时" + (endTime-startTime) + "毫秒");
        System.out.println("查询到" + docs.totalHits + "条记录");

        //取出每条查询结果
        for (ScoreDoc scoreDoc : docs.scoreDocs){
            //scoreDoc.doc相当于 docID，根据这个 docID 来获取文档
            Document document = searcher.doc(scoreDoc.doc);
            //fullPath 是刚刚建立索引的时候我们定义的一个字段，表示路径。也可以取其他的内容，只要我们在建立索引时有定义即可。
            System.out.println(document.get("fileName"));
            System.out.println(document.get("fullPath"));
        }
        reader.close();
    }


    public static void main(String[] args) {
        String indexDir = "C:\\lucene";
        //查询这个字符串
        String q = "security";
        try {
            search(indexDir, q);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
