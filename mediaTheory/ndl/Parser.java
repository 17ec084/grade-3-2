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
		has15 = books.length==15;
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

	/*
	 * ヒント: bookの内容例は次のとおり
R100000001-I005612946-00">放送学序説</a>
    </h3>
    <p>
      ＮＨＫ総合放送文化研究所放送学研究室／編
      <span style="padding-left:5px;">
        日本放送出版協会
        1975

      </span>
    </p>
  </div>
</li>

        </div><div id="list_item_1" class="type-thumbnail">
          <li class="item_result item_book itempadding" style="">
  <div class="material_image">
    <img alt="資料種別" height="115" onError="this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';" src="/images/ndl/ico_class_thumbnail_book.gif?1515070139" width="115" />
  </div>
  <div class="material_category">
      図書
  </div>
  <div class="item_summarywrapper">
    <h3>

	 */

	private String getLink(String book){return "https://iss.ndl.go.jp/books/"+book.split("\"")[0];}//「"」で区切った0番目を返せばよい
	private String getTitle(String book){return book.split("<|>")[1];}//「<」または「>」で区切った1番目を返せばよい
	private String[] getAuthors(String book){return book.split("(\r\n)|\r|\n")[3].replaceFirst("( |\t)*", "").split("／([^,])+,?");}
	private String getPublisher(String book){return book.split("(\r\n)|\r|\n")[5].replaceFirst("( |\t)*", "");}
	private String getYear(String book){return book.split("(\r\n)|\r|\n")[6].replaceFirst("( |\t)*", "");}
	private String getSeries(String book){return book.split("(\r\n)|\r|\n")[7].replaceFirst("( |\t)*", "");}


}


/*	try
	{
		  File file = new File("c:¥¥tmp¥¥test.txt");
		  FileReader filereader = new FileReader(file);

		  int ch;
		  while((ch = filereader.read()) != -1){
		    System.out.print((char)ch);
		  }
	}catch(FileNotFoundException e){
	  System.out.println(e);
	}catch(IOException e){
	  System.out.println(e);
	}
*/

