package ndl;

import java.io.FileWriter;
import java.io.IOException;

public class Main
{
	public static void main(String...args)
	{
		String header = "国立国会図書館リンク,タイトル,著者,出版者,年,シリーズ,図書館\n";
		NDLCrawler c = new NDLCrawler();
		c.setBunrui("699");
		String[] libraries = libraries();
		for(String library : libraries)
		{
			System.out.println(library);
			generateCsv(library, c);
		}

	}

	private static void generateCsv(String library, NDLCrawler c)
	{
		c.setLibrary(library);
		System.out.println(1900);
		c.setYearfrom("1900");
		c.setYearto("1900");
		output(c.crawle().replaceAll("(\r\n)|\r|\n", ","+library+"\r\n"), "D:\\result.csv");//末尾追記で書き込み
		for(int year=1925; year<=2020; year++)
		{
			System.out.println(" "+year+"("+library+")");
			c.setYearfrom(""+year);
			c.setYearto(""+year);
			output(c.crawle().replaceAll("(\r\n)|\r|\n", ","+library+"\r\n"), "D:\\result.csv");//末尾追記で書き込み
		}
	}

	private static void output(String csv, String path)
	{
		System.out.println("出力"+csv);
							try{
		FileWriter fw = new FileWriter(path, true);//第2引数trueで末尾追記モード
		fw.write(csv);
		fw.close();
							} catch (IOException e) {e.printStackTrace();}
	}

	private static String[] libraries()
	{
		String[] strs =
{
"国立国会図書館",
"大阪市立図書館",
"大阪府立中央図書館",
"岡山県立図書館",
"横浜市立図書館",
"名古屋市鶴舞中央図書館",
"堺市立中央図書館",
"滋賀県立図書館",
"福岡市総合図書館",
"広島市立中央図書館",
"北海道立図書館",
"徳島県立図書館",
"静岡市立中央図書館",
"福井県立図書館",
"東京都立中央図書館",
"さいたま市立中央図書館",
"千葉市中央図書館",
"愛知県図書館",
"埼玉県立熊谷図書館",
"鳥取県立図書館",
"香川県立図書館",
"大分県立図書館",
"富山県立図書館",
"福岡県立図書館",
"鹿児島県立図書館",
"秋田県立図書館",
"京都府立図書館",
"岐阜県図書館",
"石川県立図書館",
"川崎市立図書館",
"札幌市中央図書館",
"茨城県立図書館",
"広島県立図書館",
"三重県立図書館",
"長崎県立長崎図書館",
"福島県立図書館",
"山口県立山口図書館",
"山形県立図書館",
"宮城県図書館",
"宮崎県立図書館",
"和歌山県立図書館",
"県立長野図書館",
"青森県立図書館",
"島根県立図書館",
"岩手県立図書館",
"佐賀県立図書館",
"群馬県立図書館",
"愛媛県立図書館",
"兵庫県立図書館",
"沖縄県立図書館",
"山梨県立図書館",
"熊本県立図書館",
"千葉県立中央図書館",
"高知県立図書館",
"新潟県立図書館",
"静岡県立中央図書館",
"大阪府立中之島図書館",
"栃木県立図書館",
"東京都立多摩図書館",
"神奈川県立図書館",
"奈良県立図書情報館",
"神奈川県立川崎図書館",
"千葉県立東部図書館",
"千葉県立西部図書館",
"京都府立京都学・歴彩館",
"埼玉県立久喜図書館",
"大阪府立中央図書館国際児童文学",
"若狭図書学習センター",
"白百合女子大学図書館"
};
		return strs;
	}
}
