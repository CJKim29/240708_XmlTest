package util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import xml.vo.BookVo;

public class MySearchUtil2 {
	//객체 생성 하지않기 위해 static
	public static List<BookVo> search_shop(String b_name,int start,int display)
	{
		List<BookVo> list = new ArrayList<BookVo>();
		String clientId = "P_393QsOgSTwa1EZVd7A";
		String clientSecret = "JXdXUTahom";

		try {
			b_name = URLEncoder.encode(b_name, "utf-8");
			String urlStr = String.format("https://openapi.naver.com/v1/search/book.xml?query=%s&start=%d&display=%d",
							b_name,start,display
					);

			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			//발급받은 ID
			connection.setRequestProperty("X-Naver-Client-Id", clientId); 
			//발급받은 PW
			connection.setRequestProperty("X-Naver-Client-Secret", clientSecret); 
			// 받을요청타입
			connection.setRequestProperty("Content-Type", "application/xml"); 
			connection.connect();

			SAXBuilder builder = new SAXBuilder();
			Document   doc = builder.build (connection.getInputStream());

			Element  root     = doc.getRootElement();
			List<Element>   item_list = root.getChild("channel").getChildren("item");
			
			int no = start;

			for(Element item : item_list){
				String title = item.getChildText("title");
				String link  = item.getChildText("link");
				String image = item.getChildText("image");
				String author= item.getChildText("author");
				int discount=0;
				int pubdate=0;
				try {
					discount = Integer.parseInt(item.getChildText("discount"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				String 	publisher = item.getChildText("publisher");
				
				try {
					pubdate = Integer.parseInt(item.getChildText("pubdate"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				
				//상품목록을 포장
				BookVo vo = new BookVo();
				vo.setNo(no++);
				vo.setTitle(title);
				vo.setLink(link);
				vo.setImage(image);
				vo.setAuthor(author);
				vo.setDiscount(discount);
				vo.setPublisher(publisher);
				vo.setPubdate(pubdate);
								
				//ArrayList에 넣기
				list.add(vo);
				

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}
	
	
}
