package ndl;

public class Parser
{
	private boolean has15;
	private String csv;

	Parser(String source, boolean needHeader)
	{
		this.csv=needHeader?"国立国会図書館リンク,タイトル,著者,出版者,年,シリーズ\n":"\n";
		String[] books = divide(source);//「<a href="https://iss.ndl.go.jp/books/」で区切る
		books = remove0(books);//先頭だけ無意味なデータなので切り落とす
		has15 = books.length==15;//デフォルトで、検索結果の件数は1ページあたり15件
		String link, title, publisher, year, series;
		String[] authors;
		for(String book : books)//それぞれの書籍について
		{
			book = book.replaceAll("((\r\n)|\r|\n)( |\t)*<span style=\"font-weight:normal;\">[^<]+</span>","");
			link = getLink(book).replaceAll(",", "、");
			title = getTitle(book).replaceAll(",", "、");
			authors = getAuthors(book);
			publisher = getPublisher(book).replaceAll(",", "、");
			year = getYear(book).replaceAll(",", "、");
			series = getSeries(book).replaceAll(",", "、");//詳細情報を抽出して
			for(String author : authors)//csvに変換
				csv = csv + link+","+title+","+author.replaceAll(",", "、")+","+publisher+","+year+","+series+"\n";
		}
	}

	public boolean has15(){return has15;}
	public String parse() {return csv;}

	//本当はよくないprivateメソッドたち
	private String[] divide(String source){return source.split("<a href=\"https://iss\\.ndl\\.go\\.jp/books/", -1);}
	private String[] remove0(String[] before)
	{
		String[] after = new String[before.length-1];
		for(int i=1; i<before.length; i++)after[i-1]=before[i];
		return after;
	}
	private String getLink(String book){return "https://iss.ndl.go.jp/books/"+book.split("\"")[0];}//「"」で区切った0番目を返せばよい
	private String getTitle(String book){return book.split("<|>")[1];}//「<」または「>」で区切った1番目を返せばよい
	private String[] getAuthors(String book){return book.split("(\r\n)|\r|\n")[3].replaceFirst("( |\t)*", "").split("／([^,])+,?");}
	private String getPublisher(String book){return book.split("(\r\n)|\r|\n")[5].replaceFirst("( |\t)*", "");}
	private String getYear(String book){return book.split("(\r\n)|\r|\n")[6].replaceFirst("( |\t)*", "");}
	private String getSeries(String book){return book.split("(\r\n)|\r|\n")[7].replaceFirst("( |\t)*", "");}


}
