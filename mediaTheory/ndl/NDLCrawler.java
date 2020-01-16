package ndl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 国立国会図書館サーチ(詳細検索)へアクセスし、書籍情報をCSV形式でまとめる。<br>
 * 検索パラメータについて:2020/01/15現在のテキストボックスの項目のみすべて指定可能。<br>
 * setTitle<br>
 * setAuthor<br>
 * setPublisher<br>
 * setYearfrom<br>
 * setYearto<br>
 * setSubject<br>
 * setBunrui<br>
 * setIsbn_issn<br>
 * setPlace<br>
 * プルダウン(翻訳検索)は「翻訳検索しない」<br>
 * チェックボックスはすべて選択のものとする。<br>
 * また、所属館は以下から選択可能。<br>
 * 国立国会図書館<br>
 * 大阪市立図書館<br>
 * 大阪府立中央図書館<br>
 * 岡山県立図書館<br>
 * 横浜市立図書館<br>
 * 名古屋市鶴舞中央図書館<br>
 * 堺市立中央図書館<br>
 * 滋賀県立図書館<br>
 * 福岡市総合図書館<br>
 * 広島市立中央図書館<br>
 * 北海道立図書館<br>
 * 徳島県立図書館<br>
 * 静岡市立中央図書館<br>
 * 福井県立図書館<br>
 * 東京都立中央図書館<br>
 * さいたま市立中央図書館<br>
 * 千葉市中央図書館<br>
 * 愛知県図書館<br>
 * 埼玉県立熊谷図書館<br>
 * 鳥取県立図書館<br>
 * 香川県立図書館<br>
 * 大分県立図書館<br>
 * 富山県立図書館<br>
 * 福岡県立図書館<br>
 * 鹿児島県立図書館<br>
 * 秋田県立図書館<br>
 * 京都府立図書館<br>
 * 岐阜県図書館<br>
 * 石川県立図書館<br>
 * 川崎市立図書館<br>
 * 札幌市中央図書館<br>
 * 茨城県立図書館<br>
 * 広島県立図書館<br>
 * 三重県立図書館<br>
 * 長崎県立長崎図書館<br>
 * 福島県立図書館<br>
 * 山口県立山口図書館<br>
 * 山形県立図書館<br>
 * 宮城県図書館<br>
 * 宮崎県立図書館<br>
 * 和歌山県立図書館<br>
 * 県立長野図書館<br>
 * 青森県立図書館<br>
 * 島根県立図書館<br>
 * 岩手県立図書館<br>
 * 佐賀県立図書館<br>
 * 群馬県立図書館<br>
 * 愛媛県立図書館<br>
 * 兵庫県立図書館<br>
 * 沖縄県立図書館<br>
 * 山梨県立図書館<br>
 * 熊本県立図書館<br>
 * 千葉県立中央図書館<br>
 * 高知県立図書館<br>
 * 新潟県立図書館<br>
 * 静岡県立中央図書館<br>
 * 大阪府立中之島図書館<br>
 * 栃木県立図書館<br>
 * 東京都立多摩図書館<br>
 * 神奈川県立図書館<br>
 * 奈良県立図書情報館<br>
 * 神奈川県立川崎図書館<br>
 * 千葉県立東部図書館<br>
 * 千葉県立西部図書館<br>
 * 京都府立京都学・歴彩館<br>
 * 埼玉県立久喜図書館<br>
 * 大阪府立中央図書館国際児童文学<br>
 * 若狭図書学習センター<br>
 * setLibrary
 * @author <a href=http://github.com/17ec084>Tomotaka Hirata(17ec084)</a>
 *
 */
public class NDLCrawler
{
	private String url = "https://iss.ndl.go.jp/books?",
	title="", author="", publisher="", yearfrom="",yearto="", subject="", bunrui="", isbn_issn="", place="", library="";
	public void setTitle(String str){title=str;} public void setAuthor(String str){author=str;} public void setPublisher(String str){publisher=str;} public void setYearfrom(String str){yearfrom=str;} public void setYearto(String str){yearto=str;} public void setSubject(String str){subject=str;} public void setBunrui(String str){bunrui=str;} public void setIsbn_issn(String str){isbn_issn=str;} public void setPlace(String str){place=str;} public void setLibrary(String str){library=str;}
	public String crawle()
	{
		System.out.println("  クローラ起動");
		String csv="";
		String urlWithGet = url+ "rft.title=" + title + "&rft.au=" + author + "&rft.pub=" + publisher + "&datefrom=" + yearfrom + "&dateto=" + yearto + "&subject=" + subject + "&ndc=" + bunrui + "&rft.isbn=" + isbn_issn + "&place=" + place;
		if(!library.equals(""))
			urlWithGet = urlWithGet + "&filters[]=3_" + library;
		urlWithGet = urlWithGet + "&do_remote_search=true&display=thumbnail&search_mode=advanced";
		System.out.println("  url:"+urlWithGet+"&page=(ページ番号)");
		WebGetter wg = new WebGetter();
							try {
		for(int page=1; page<=34; page++)
		{
			System.out.println("   "+page+"ページ目");
			String source = wg.get(urlWithGet+"&page="+page);
			Parser p = new Parser(source, false);
			csv = csv + p.parse().replaceFirst("^(\r\n|\r|\n)", "");
			if(!p.has15()) break;
		}
		System.out.println("  クローラ終了");
		return csv;
							} catch (IOException e) {e.printStackTrace();return null;}

	}
}

/**
 *
 * 参考サイト:https://www.javalife.jp/2018/04/25/java-%E3%82%A4%E3%83%B3%E3%82%BF%E3%83%BC%E3%83%8D%E3%83%83%E3%83%88%E3%81%AE%E3%82%B5%E3%82%A4%E3%83%88%E3%81%8B%E3%82%89html%E3%82%92%E5%8F%96%E5%BE%97%E3%81%99%E3%82%8B/
 *
 */
class WebGetter
{
	String get(String url) throws MalformedURLException, IOException
	{
		InputStream is = null; InputStreamReader isr = null; BufferedReader br = null;
							try {
		URLConnection conn = new URL(url).openConnection();
		is = conn.getInputStream();
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);

		String line, source="";
		while((line = br.readLine()) != null)
			source=source+line+"\r\n";
    	return source;
							}finally {br.close();isr.close();is.close();}
	}

}


