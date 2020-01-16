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

/*
	public static void main(String[] args)
	{
		Parser p = new Parser("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" +
				"<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"ja\" lang=\"ja\">\r\n" +
				"<head>\r\n" +
				"<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\r\n" +
				"<meta http-equiv=\"content-style-type\" content=\"text/css\" />\r\n" +
				"<meta http-equiv=\"content-script-type\" content=\"text/javascript\" />\r\n" +
				"<meta name=\"csrf-param\" content=\"authenticity_token\"/>\r\n" +
				"<meta name=\"csrf-token\" content=\"cCtb+E5Hh/XzO3OKbc03t6vmLynhtg6K5TEji4JNp9k=\"/>\r\n" +
				"<link rel=\"search\" type=\"application/opensearchdescription+xml\" title=\"NDL Search\" href=\"https://iss.ndl.go.jp/api/opensearch_description\" />\r\n" +
				"  <link href=\"/stylesheets/ndl/styles.css?1522923322\" media=\"\" rel=\"stylesheet\" type=\"text/css\" />\r\n" +
				"  \r\n" +
				"<link href=\"/stylesheets/ndl/styles_print.css?1539154175\" media=\"print\" rel=\"stylesheet\" type=\"text/css\" />\r\n" +
				"<script src=\"/javascripts/ndl/jquery-1.4.2.min.js?1515070139\" type=\"text/javascript\"></script>\r\n" +
				"<script src=\"/javascripts/ndl/jquery-ui-1.8.6.custom.min.js?1515070139\" type=\"text/javascript\"></script>\r\n" +
				"<script src=\"/javascripts/ndl/jquery.cookie.js?1515070139\" type=\"text/javascript\"></script>\r\n" +
				"<script src=\"/javascripts/rails.js?1515070139\" type=\"text/javascript\"></script>\r\n" +
				"<script src=\"/javascripts/ndl/init.js?1515070139\" type=\"text/javascript\"></script>\r\n" +
				"<link href=\"/stylesheets/ndl/style_dialog.css\" media=\"\" rel=\"stylesheet\" type=\"text/css\" />\r\n" +
				"\r\n" +
				"<script type=\"text/javascript\" defer src=\"https://api.jglobal.jst.go.jp/webapi/api.js.php?key=JDEkcmFzbXVzbGUkek1jMnpaU0U5TzRmZHZENTYuZTJNMA==\" charset=\"UTF-8\"></script>\r\n" +
				"<script type=\"text/javascript\">\r\n" +
				"//<![CDATA[\r\n" +
				"\r\n" +
				"window.onload = function(){\r\n" +
				"    api_invoke();\r\n" +
				"};\r\n" +
				"\r\n" +
				"function api_invoke(key){\r\n" +
				"  if (search_keywords != '' && contents != null) {\r\n" +
				"    if(typeof jglobal != \"function\" || typeof jglobal.search != \"function\") {\r\n" +
				"      return true;\r\n" +
				"    }\r\n" +
				"    var jgs = new jglobal.search();\r\n" +
				"    jgs.getJSONforTerm(\"jg_callback\", search_keywords, 1);\r\n" +
				"  }\r\n" +
				"  return false;\r\n" +
				"}\r\n" +
				"\r\n" +
				"function jg_callback(json){\r\n" +
				"  var main_html = \"\";\r\n" +
				"  var data_html = \"\";\r\n" +
				"  var hit_cnt = 0;\r\n" +
				"  var item = \"\";\r\n" +
				"  if(json.error != undefined){\r\n" +
				"          return false;\r\n" +
				"  }\r\n" +
				"  for( var i = 0; i < json.items.length; i ++ ){\r\n" +
				"    item = json.items[i].TM.J.replace(/<\\/?[^>]+>/gi, '');\r\n" +
				"    if( search_keywords.indexOf(item) < 0 ){\r\n" +
				"      hit_cnt ++;\r\n" +
				"      if( hit_cnt > disp_cnt ){\r\n" +
				"        data_html += '<li class=\"additional\"><a href=\"' + books_url + \"?any=\" + encodeURI(item) + '\">' + json.items[i].TM.J + '</a></li>';\r\n" +
				"      }else{\r\n" +
				"        data_html += '<li><a href=\"' + books_url + \"?any=\" + encodeURI(item) + '\">' + json.items[i].TM.J + '</a></li>';\r\n" +
				"      }\r\n" +
				"    }\r\n" +
				"  }\r\n" +
				"\r\n" +
				"  if( hit_cnt > 0 ){\r\n" +
				"    main_html += '<h2 class=\"mainlabel\">';\r\n" +
				"    main_html += '科学技術用語';\r\n" +
				"    main_html += '</h2>';\r\n" +
				"    main_html += '<p>Powered by <a href=\\\"javascript:void(window.open(\\'http://jglobal.jst.go.jp/\\',\\'jstwindow\\'))\\\">J-GLOBAL</a></p>'\r\n" +
				"    main_html += '<div class=\"subgroup\" id=\"jglobal_content\">';\r\n" +
				"    main_html += '<ul class=\"sub-ul\">';\r\n" +
				"    main_html += data_html;\r\n" +
				"    main_html += '</ul>';\r\n" +
				"    if( hit_cnt > disp_cnt ){\r\n" +
				"      main_html += '<div class=\"show-wrapper\">';\r\n" +
				"      main_html += '<span class=\"showall\"><a href=\"#\">▼全て表示</a></span><span class=\"showsome\"><a href=\"#\">▲一部を表示</a></span>';\r\n" +
				"      main_html += '</div>';\r\n" +
				"    }\r\n" +
				"    main_html += '</div>';\r\n" +
				"\r\n" +
				"    contents.innerHTML = main_html;\r\n" +
				"\r\n" +
				"    var jglobalArea = $('#jglobal_content');\r\n" +
				"    setShowAllSwitch($('.showall', jglobalArea), $('.showsome', jglobalArea), $('.additional', jglobalArea));\r\n" +
				"\r\n" +
				"    return true;\r\n" +
				"\r\n" +
				"  }\r\n" +
				"\r\n" +
				"}\r\n" +
				"\r\n" +
				"\r\n" +
				"//]]>\r\n" +
				"</script>\r\n" +
				"  <script type=\"text/javascript\">\r\n" +
				"\r\n" +
				"    document.onkeydown = function(e) { \r\n" +
				"        if(!e) {\r\n" +
				"            if(window.event.keyCode == 116) {\r\n" +
				"                window.event.keyCode = 1; // IE8対応 keyCode 1 は存在しない\r\n" +
				"                return false;\r\n" +
				"            }\r\n" +
				"        } else {\r\n" +
				"            if(e.which == 116) {\r\n" +
				"                return false;\r\n" +
				"            }\r\n" +
				"        }\r\n" +
				"    };\r\n" +
				"\r\n" +
				"    \r\n" +
				"    // 並び換えのプルダウンメニューが選択されたときに呼び出される関数\r\n" +
				"    function change_page_with_sort_type(obj) {\r\n" +
				"      var url = \"https://iss.ndl.go.jp/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&ar=4e1f&except_repository_nos[]=R100000038&except_repository_nos[]=R100000049&except_repository_nos[]=R100000073&do_remote_search=true&display=thumbnail&ndc=699&search_mode=advanced\";\r\n" +
				"      para_sym = (url.indexOf('?') > 1) ? \"&\" : \"?\";\r\n" +
				"      if (obj.value) {\r\n" +
				"        window.location.href= url + para_sym + \"sort=\" + obj.value;\r\n" +
				"      } else {\r\n" +
				"        window.location.href= url;\r\n" +
				"      }\r\n" +
				"    }\r\n" +
				"    //]]>\r\n" +
				"\r\n" +
				"    // Show or Hide Multisearching Indicatior\r\n" +
				"    (function($){\r\n" +
				"      var multisearchingIndicator = function( isVisible ){\r\n" +
				"        if ( isVisible ) { // Show\r\n" +
				"          var colorBefore = '#030';\r\n" +
				"          var colorAfter = '#080';\r\n" +
				"          var speed = 1200;\r\n" +
				"          var effect = 'linear';\r\n" +
				"          $(function(){\r\n" +
				"            var wrapper = $( '#tabs-search' );\r\n" +
				"            if ( wrapper.length > 0 ) {\r\n" +
				"              var indicator = $( '<div class=\"indicator-multisearching\"><div class=\"im-label\">横断検索実行中...(%)</div><div class=\"im-stop\" onclick=\"multisearchingIndicator( false )\">停止</div><div class=\"dropshadow dropshadow-up\">&nbsp;</div></div>' );\r\n" +
				"              indicator.css( 'background-color', colorBefore );\r\n" +
				"              var animate = function(){\r\n" +
				"                indicator.animate(\r\n" +
				"                { backgroundColor: colorAfter },\r\n" +
				"                speed,\r\n" +
				"                effect,\r\n" +
				"                function(){\r\n" +
				"                  indicator.animate(\r\n" +
				"                  { backgroundColor: colorBefore },\r\n" +
				"                  speed,\r\n" +
				"                  effect,\r\n" +
				"                  animate\r\n" +
				"                )\r\n" +
				"                }\r\n" +
				"              );\r\n" +
				"              };\r\n" +
				"              indicator.hide();\r\n" +
				"              wrapper.append( indicator );\r\n" +
				"              indicator.slideDown( 'slow', function(){\r\n" +
				"                animate();\r\n" +
				"              } );\r\n" +
				"            };\r\n" +
				"          });\r\n" +
				"        } else { // Hide\r\n" +
				"          var indicator = $( '.indicator-multisearching' );\r\n" +
				"          if ( indicator.length > 0 ) {\r\n" +
				"            indicator.slideUp( 'fast', function(){ indicator.remove(); } );\r\n" +
				"          };\r\n" +
				"          if(typeof(indicatorStop) == 'function') {\r\n" +
				"            indicatorStop();\r\n" +
				"          }\r\n" +
				"        };\r\n" +
				"      };\r\n" +
				"      window.multisearchingIndicator = multisearchingIndicator; // Expose to the globe.\r\n" +
				"    })(jQuery);\r\n" +
				"\r\n" +
				"  </script>\r\n" +
				"\r\n" +
				"<title>詳細検索結果｜「699」に一致する資料： 2544件中1から100件目｜国立国会図書館サーチ</title>\r\n" +
				"\r\n" +
				"<script type=\"text/javascript\" charset=\"utf-8\" src=\"/javascripts/ndl/accessibility.js\"></script>\r\n" +
				"<script type=\"text/javascript\" charset=\"utf-8\" src=\"/javascripts/lib/shortcut.js\"></script>\r\n" +
				"</head>\r\n" +
				"<body class=\"result result2\" >\r\n" +
				"    <noscript>\r\n" +
				"    <style type=\"text/css\"><!--\r\n" +
				"      div#search-advanced    { display: block; }\r\n" +
				"      div#search-handicapped { display: block; }\r\n" +
				"      --></style>\r\n" +
				"  </noscript>\r\n" +
				"\r\n" +
				"<style> div#header div.utilmenu { float: none; } </style>\r\n" +
				"\r\n" +
				"<p class=\"guidance\"><a name=\"PTOP\" id=\"PTOP\"></a></p>\r\n" +
				"<p class=\"guidance\"><img alt=\"サイトメニューここから\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /><a name=\"PTOP\" id=\"PTOP\"><img alt=\"このページの先頭です\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></a></p>\r\n" +
				"  <p class=\"guidance\" id=\"shortcut_description\"><a href=\"#\"><img alt=\"ショートカットキーの説明を開始します。画面遷移や機能実行は、説明にあるショートカットキーを同時に押した後、Enterキーを押してください。ショートカットキーの説明を聞くには、Alt＋0。トップ画面の表示には、Alt＋1。ログインを行うには、Alt＋2。簡易検索画面の表示には、Alt＋3。詳細検索画面の表示には、Alt＋4。障害者向け資料検索画面の表示には、Alt＋5。検索結果の並び替えを行うには、Alt＋6。国立国会図書館ホームページの表示には、Alt＋7。検索結果の絞り込みを行うには、Alt＋8。以上でショートカットキーの説明を終わります。\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></a></p>\r\n" +
				"\r\n" +
				"    <div id=\"header\" class=\"header\">\r\n" +
				"    <p class=\"guidance\"><a href=\"#resultlist\">検索結果一覧へ移動</a></p>\r\n" +
				"    <p id=\"systemname\"><a href=\"/\" onfocus=\"popuppanel_login_hide()\">国立国会図書館サーチ</a></p>\r\n" +
				"\r\n" +
				"  <div class=\"utilmenu\">\r\n" +
				"        \r\n" +
				"        <ul style=\"display:inline-block; float: right;\">\r\n" +
				"            <div class=\"login-btn\" title='ログイン' >                          <a href=\"/login?target=/books?filters[]=3_%25E5%25A4%25A7%25E9%2598%25AA%25E5%25B8%2582%25E7%25AB%258B%25E5%259B%25B3%25E6%259B%25B8%25E9%25A4%25A8&ar=4e1f&except_repository_nos[]=R100000038&except_repository_nos[]=R100000049&except_repository_nos[]=R100000073&do_remote_search=true&display=thumbnail&ndc=699&search_mode=advanced\" class='popup-login'>\r\n" +
				"        ログイン\r\n" +
				"      </a>\r\n" +
				" </div>\r\n" +
				"      <li class=\"setting\"><a href=\"/users/edit\" onfocus=\"popuppanel_login_hide()\">設定</a></li>\r\n" +
				"      \r\n" +
				"      <li class=\"help\"><img alt=\"新しいウインドウが開きます\" class=\"guidance \" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" />\r\n" +
				"        <a href=\"https://iss.ndl.go.jp/information/help/\" target=\"_blank\" onfocus=\"popuppanel_lang_hide()\" >ヘルプ</a>\r\n" +
				"      </li>\r\n" +
				"        <li class=\"box\"><a href=\"javascript:void(0)\" class=\"triangle triangle-white-rightdown popup-lang\"><img alt=\"画面の表示言語のリストです。言語の選択が可能です。\" class=\"guidance \" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" />Language</a><div class=\"popuppanel popuppanel-lang\" id=\"popuppanel-lang\" style=\"margin-left: -2em\">\r\n" +
				"          <ul>\r\n" +
				"            <li><a href=\"/books?locale=ja&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">日本語 (Japanese)</a></li>\r\n" +
				"            <li><a href=\"/books?locale=zh&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">简体中文（Chinese）</a></li>\r\n" +
				"            <li><a href=\"/books?locale=ko&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">한국어（Korean）</a></li>\r\n" +
				"            <li><a href=\"/books?locale=en&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">English</a></li>\r\n" +
				"          </ul>\r\n" +
				"        </div></li>\r\n" +
				"\r\n" +
				"        <li class=\"box font-size\"><a href=\"javascript:void(0)\" onfocus=\"popuppanel_lang_hide()\" >文字拡大</a></li>\r\n" +
				"        <li class=\"box monochrome\"><a href=\"javascript:void(0)\">白黒反転</a></li>\r\n" +
				"\r\n" +
				"    </ul>\r\n" +
				"  </div>\r\n" +
				"  <p class=\"guidance\"><img alt=\"サイトメニューここまで\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></p>\r\n" +
				"</div>\r\n" +
				"\r\n" +
				"\r\n" +
				"<script type=\"text/javascript\">\r\n" +
				"//<![CDATA[\r\n" +
				"  //popuppanel_loginの非表示処理\r\n" +
				"  var popuppanel_login_hide = function(){\r\n" +
				"    $(\"#popuppanel-login\").hide();\r\n" +
				"  };\r\n" +
				"\r\n" +
				"  //popuppanel_langの非表示処理\r\n" +
				"  var popuppanel_lang_hide = function(){\r\n" +
				"    $(\"#popuppanel-lang\").hide();\r\n" +
				"  };\r\n" +
				"\r\n" +
				"  //DOMがロードされたときの処理\r\n" +
				"  $(document).ready(function($){\r\n" +
				"    //文字拡大処理\r\n" +
				"    //cookieが存在しない場合、フォントサイズ最小値を設定する\r\n" +
				"    if($.cookie(\"ndlFontSizeStyle\") == null){\r\n" +
				"      $.cookie(\"ndlFontSizeStyle\", inputMinFontSize, {path:'/' });\r\n" +
				"    }\r\n" +
				"    //tmpNowFontSizeに一つ前のフォントサイズ係数を設定し、changeFontSizeに処理を依頼\r\n" +
				"    if(eval($.cookie(\"ndlFontSizeStyle\")) == inputMinFontSize){\r\n" +
				"      tmpNowFontSize = inputMaxFontSize + 1;\r\n" +
				"    }else{\r\n" +
				"      tmpNowFontSize = eval($.cookie(\"ndlFontSizeStyle\")) - 1 ;\r\n" +
				"    }\r\n" +
				"    changeFontSize();\r\n" +
				"    \r\n" +
				"    //白黒反転処理\r\n" +
				"    if(eval($.cookie(\"ndlColorChangeFlag\")) == 1){\r\n" +
				"      // 白黒反転適用\r\n" +
				"      $(\"body\").addClass(\"monochrome\");\r\n" +
				"      $(\"a.sso\").css(\"color\", \"#FFFF99\");\r\n" +
				"      /* 白黒反転フラグを有効化 * /\r\n" +
				"      tmpColorChangeFlag = 1;\r\n" +
				"      $.cookie(\"ndlColorChangeFlag\", 1, {path:'/' });\r\n" +
				"    }else{\r\n" +
				"      $(\"body\").removeClass(\"monochrome\");\r\n" +
				"      $(\"a.sso\").css(\"color\", \"\");\r\n" +
				"      /* 白黒反転フラグを無効化 * /\r\n" +
				"      tmpColorChangeFlag = 0;\r\n" +
				"      $.cookie(\"ndlColorChangeFlag\", 0, {path:'/' });\r\n" +
				"    }\r\n" +
				"\r\n" +
				"  });\r\n" +
				"\r\n" +
				"  //文字拡大がクリックされたときの処理\r\n" +
				"  $(\"li.font-size a\").click(function(){\r\n" +
				"    // フォントサイズ係数が最大値以下の場合\r\n" +
				"    if(eval($.cookie(\"ndlFontSizeStyle\")) <= inputMaxFontSize){\r\n" +
				"      $.cookie(\"ndlFontSizeStyle\", eval($.cookie(\"ndlFontSizeStyle\")) + 1, {path:'/' });\r\n" +
				"    }else{\r\n" +
				"      // フォントサイズ係数が最大値を超えた場合はデフォルトに戻す\r\n" +
				"      $.cookie(\"ndlFontSizeStyle\", inputMinFontSize, {path:'/' });\r\n" +
				"    }\r\n" +
				"  });\r\n" +
				"\r\n" +
				"  //白黒反転がクリックされたときの処理\r\n" +
				"  $(\"li.monochrome a\").click(function(){\r\n" +
				"    if( eval($.cookie(\"ndlColorChangeFlag\")) == 1){//ture(白黒反転適用)の場合\r\n" +
				"      $.cookie(\"ndlColorChangeFlag\", 0, {path:'/' });\r\n" +
				"    }else{//上記以外(白黒反転無効)の場合\r\n" +
				"      $.cookie(\"ndlColorChangeFlag\", 1, {path:'/' });\r\n" +
				"    }\r\n" +
				"  });\r\n" +
				"\r\n" +
				"\r\n" +
				"\r\n" +
				"//]]>\r\n" +
				"</script>\r\n" +
				"<!--[if IE 6]>\r\n" +
				"<iframe class=\"shim\" frameborder=\"0\" width=\"0\" height=\"0\"></iframe>\r\n" +
				"<![endif]-->\r\n" +
				"\r\n" +
				"\r\n" +
				"<div id=\"tabs-search\" class=\"tabs-search\"><p class=\"guidance\"><a name=\"search-guidance\" id=\"search-guidance\"></a></p>\r\n" +
				"<p class=\"guidance\"><img alt=\"検索メニューここから\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></p>\r\n" +
				"  <div class=\"tabs-search-trigger-wrapper\">\r\n" +
				"    <ul class=\"tabs-search-trigger\">\r\n" +
				"      <li class=\"tabtrigger-first\"><a href=\"#search-normal\">簡易検索</a></li><li class=\"tabtrigger-second\"><a href=\"#search-advanced\">詳細検索</a></li><li class=\"tabtrigger-third\"><a href=\"#search-handicapped\">障害者向け資料検索</a></li>\r\n" +
				"    </ul>\r\n" +
				"  </div>\r\n" +
				"\r\n" +
				"<script type=\"text/javascript\">\r\n" +
				"//<![CDATA[\r\n" +
				"$.fn.disableOnSubmit_for_search = function(disableList){\r\n" +
				"	if(disableList == null){var $list = 'input[type=submit],input[type=button],input[type=reset],button';}\r\n" +
				"	else{var $list = disableList;}\r\n" +
				"\r\n" +
				"	// Makes sure button is enabled at start\r\n" +
				"	$(this).find($list).removeAttr('disabled');\r\n" +
				"	$(this).submit(function(){\r\n" +
				"    if ($(this).find('#searchbox').length){\r\n" +
				"    //簡易検索の２重送信抑止\r\n" +
				"      if ($(this).find('#searchbox').val() != ''){\r\n" +
				"        //空検索時には非活性としない\r\n" +
				"        $(this).find($list).attr('disabled','disabled');\r\n" +
				"      }\r\n" +
				"    }else if ( ($(this).find('#searchbutton_advanced').length)){\r\n" +
				"    //詳細検索の２重送信抑止\r\n" +
				"      if (get_advanced_text_cnt() > 0){\r\n" +
				"        //空検索時には非活性としない\r\n" +
				"        $(this).find($list).attr('disabled','disabled');\r\n" +
				"      }\r\n" +
				"    }else{\r\n" +
				"      //簡易検索,詳細検索以外の２重送信抑止\r\n" +
				"      $(this).find($list).attr('disabled','disabled');\r\n" +
				"    }\r\n" +
				"  });\r\n" +
				"  return this;\r\n" +
				"};\r\n" +
				"\r\n" +
				"$(function(){\r\n" +
				"  $('#searchwrapper').disableOnSubmit_for_search();\r\n" +
				"  $('#search_advanced_form').disableOnSubmit_for_search();\r\n" +
				"  $('#search_handicapped_form').disableOnSubmit_for_search();\r\n" +
				"});\r\n" +
				"\r\n" +
				"function valid_submit(){\r\n" +
				"    //空検索と非活性時にはfalse\r\n" +
				"    return (document.getElementById('searchbox').value != '' && !document.getElementById('searchbutton').disabled)\r\n" +
				"  }\r\n" +
				"\r\n" +
				"function valid_submit_advanced(){\r\n" +
				"    //空検索と非活性時にはfalse\r\n" +
				"    return (get_advanced_text_cnt() > 0 && !document.getElementById('searchbutton_advanced').disabled)\r\n" +
				"  }\r\n" +
				"// 出版年バリデーションチェック(詳細検索)\r\n" +
				"function valid_date(){\r\n" +
				"  if (!valid_submit_advanced()) return false\r\n" +
				"  $('.valid-date').text('');\r\n" +
				"  $('#datefrom').val($('#datefrom').val().replace(/\\s+/g, \"\"))\r\n" +
				"  $('#dateto').val($('#dateto').val().replace(/\\s+/g, \"\"))\r\n" +
				"  if ($('#datefrom').val() || $('#dateto').val()){\r\n" +
				"    var dates = [$('#datefrom').val(), $('#dateto').val()];\r\n" +
				"    for (var i=0; i < dates.length; i++) {\r\n" +
				"      var date = dates[i]\r\n" +
				"      if(!date){\r\n" +
				"        dates.splice(i--, 1); \r\n" +
				"        continue;\r\n" +
				"      } \r\n" +
				"      // 4,6,8桁かつ数字チェック\r\n" +
				"      if(!(([4, 6, 8].indexOf(date.length) >= 0) && date.match(/^[0-9０-９]+$/))){\r\n" +
				"        $('.valid-date').text('年(YYYY)、年月(YYYYMM)、年月日(YYYYMMDD)で指定してください。');\r\n" +
				"        return false;\r\n" +
				"      }\r\n" +
				"      dates[i] = date.replace(/[０-９]/g, function(s) {\r\n" +
				"        return String.fromCharCode(s.charCodeAt(0) - 0xFEE0);\r\n" +
				"      });\r\n" +
				"    }\r\n" +
				"    // From、Toの桁数チェック\r\n" +
				"    if (dates.length == 2){\r\n" +
				"      if (dates[0].length != dates[1].length){\r\n" +
				"        $('.valid-date').text('始点と終点を指定する場合は、同じ桁数にしてください。');\r\n" +
				"        return false;\r\n" +
				"      }\r\n" +
				"      if (dates[0] > dates[1]){\r\n" +
				"        $('.valid-date').text('終点には始点と同じ値か始点より大きい値を指定してください。');\r\n" +
				"        return false;\r\n" +
				"      }\r\n" +
				"    }\r\n" +
				"    // 確認ダイアログ\r\n" +
				"    var cookie = document.cookie.indexOf('date_confirm_flg');\r\n" +
				"    if (dates[0].length > 4 && cookie　< 0){\r\n" +
				"      $('#modal').dialog({\r\n" +
				"        modal: true,\r\n" +
				"        resizable: false,\r\n" +
				"        title: '',\r\n" +
				"        buttons: {\r\n" +
				"          OK: function() {\r\n" +
				"            if ($('#date_dialog').attr('checked')){\r\n" +
				"             document.cookie = 'date_confirm_flg=1'; \r\n" +
				"            }\r\n" +
				"            $(this).dialog( \"close\" );\r\n" +
				"            $('#search_advanced_form').submit();\r\n" +
				"          }\r\n" +
				"        }\r\n" +
				"      });  \r\n" +
				"    } else {\r\n" +
				"      $('#search_advanced_form').submit();\r\n" +
				"    }\r\n" +
				"  }else{\r\n" +
				"    $('#search_advanced_form').submit();\r\n" +
				"  }\r\n" +
				"}\r\n" +
				"function get_advanced_text_cnt(){\r\n" +
				"    var advobj,txtcnt=0;\r\n" +
				"    var elmnum=document.getElementById('search_advanced_form').length;\r\n" +
				"    for(var i=0;i<elmnum;i++){\r\n" +
				"      advobj=document.getElementById('search_advanced_form')[i];\r\n" +
				"      if(advobj.type=='text' && advobj.value != ''){\r\n" +
				"        txtcnt++;\r\n" +
				"      }\r\n" +
				"    }\r\n" +
				"    return txtcnt;\r\n" +
				"  }\r\n" +
				"\r\n" +
				"\r\n" +
				"//]]>\r\n" +
				"</script>\r\n" +
				"  <form accept-charset=\"UTF-8\" action=\"/books/search\" id=\"searchwrapper\" method=\"post\" name=\"searchForm\" onsubmit=\"return valid_submit();\"><input name=\"authenticity_token\" type=\"hidden\" value=\"cCtb+E5Hh/XzO3OKbc03t6vmLynhtg6K5TEji4JNp9k=\" />\r\n" +
				"  <a name=\"CONTENTS\" id=\"CONTENTS\"></a>\r\n" +
				"  <div id=\"search-normal\" style=\"z-index:99;\">\r\n" +
				"    <p class=\"guidance\"><img alt=\"簡易検索ここから\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></p>\r\n" +
				"    <input id=\"op_id\" name=\"op_id\" type=\"hidden\" value=\"1\" />\r\n" +
				"    \r\n" +
				"      <input id=\"filters_\" name=\"filters[]\" type=\"hidden\" value=\"3_大阪市立図書館\" />\r\n" +
				"    <div id=\"mainsearch\" style=\"margin:0 auto;text-align:center;padding-bottom:16px;\">\r\n" +
				"        <label for=\"searchbox\"><img alt=\"国立国会図書館サーチの簡易検索ページです。Alt＋0を同時に押すと、本システムのショートカットキーの説明にジャンプします。\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /><span style=\"display:none;\">国立国会図書館サーチの簡易検索ページです。Alt＋0を同時に押すと、本システムのショートカットキーの説明にジャンプします。</span>キーワード</label>\r\n" +
				"        <div style=\"display:inline-block;_display:inline;*display:inline;zoom:1;width:350px;padding-right:16px;\">\r\n" +
				"          <input autocomplete=\"off\" class=\"textbox\" id=\"searchbox\" name=\"any\" size=\"50\" type=\"text\" value=\"\" />\r\n" +
				"          <div style=\"position:relative;height:0px;overflow:visible;\">\r\n" +
				"            <p id=\"suggest_list\" style=\"position:absolute;top:0px;left:0px;text-align:left;\"></p>\r\n" +
				"          </div>\r\n" +
				"        </div>\r\n" +
				"        <input class=\"searchbutton\" id=\"searchbutton\" name=\"commit\" type=\"submit\" value=\"検索\" />\r\n" +
				"        <span class=\"transatedsearchselect\" style=\"text-align:left;width:150px;\">\r\n" +
				"            <label for=\"trans-normal\" class=\"guidance\" id=\"trans-dropdown-guide\"><img alt=\"翻訳検索の言語のリストです。翻訳する検索言語の選択が可能です。\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /><span style=\"display:none;\">翻訳検索の言語のリストです。翻訳する検索言語の選択が可能です。</span></label>\r\n" +
				"            <select id=\"trans-normal\" name=\"trans\"><option value=\"\">翻訳検索しない</option>\r\n" +
				"<option value=\"ja_ko_jserver\">韓国語に翻訳</option>\r\n" +
				"<option value=\"ja_zh_jserver\">中国語に翻訳</option>\r\n" +
				"<option value=\"ja_en_jserver\">英語に翻訳</option></select>\r\n" +
				"        </span>\r\n" +
				"        <p class=\"media-option\">\r\n" +
				"            <input id=\"do_remote_search_1\" name=\"do_remote_search\" type=\"checkbox\" value=\"\" />\r\n" +
				"          <label for=\"do_remote_search_1\">すべての<a href=\"/information/target/\" target=\"_blank\">連携先</a>を検索する</label>\r\n" +
				"          <span class=\"popup-guidance\"><img alt=\"チェックすると、検索結果表示に時間がかかるデータベースも含めて検索します。\" height=\"13\" src=\"/images/ndl/ico_popup_help.png?1515070139\" width=\"13\" /></span>\r\n" +
				"        </p>\r\n" +
				"        <p id=\"trans_hidden_val\"></p>\r\n" +
				"\r\n" +
				"    </div>\r\n" +
				"      <script type=\"text/javascript\">\r\n" +
				"//<![CDATA[\r\n" +
				"\r\n" +
				"        $(\"#do_remote_search_1\").click(function(){\r\n" +
				"          if($(\"#do_remote_search_1\").val() == \"true\"){\r\n" +
				"            $(\"#do_remote_search_1\").val(\"\");\r\n" +
				"          }else{\r\n" +
				"            $(\"#do_remote_search_1\").val(\"true\");\r\n" +
				"          }\r\n" +
				"        });\r\n" +
				"\r\n" +
				"        // サジェストキーワード\r\n" +
				"\r\n" +
				"//]]>\r\n" +
				"</script>      <p id=\"primaryfilter\">\r\n" +
				"            <span class=\"mediatype-selector\" id=\"mediatype-selector#{i}\"><input checked=\"checked\" id=\"mediatype_\" name=\"mediatype\" type=\"radio\" value=\"\" /><label for=\"material_types0\">すべて</label></span>\r\n" +
				"            <span class=\"mediatype-selector\" id=\"mediatype-selector#{i}\"><input id=\"mediatype_1\" name=\"mediatype\" type=\"radio\" value=\"1\" /><label for=\"material_types1\">本</label></span>\r\n" +
				"            <span class=\"mediatype-selector\" id=\"mediatype-selector#{i}\"><input id=\"mediatype_2\" name=\"mediatype\" type=\"radio\" value=\"2\" /><label for=\"material_types2\">記事・論文</label></span>\r\n" +
				"            <span class=\"mediatype-selector\" id=\"mediatype-selector#{i}\"><input id=\"mediatype_3\" name=\"mediatype\" type=\"radio\" value=\"3\" /><label for=\"material_types3\">新聞</label></span>\r\n" +
				"            <span class=\"mediatype-selector\" id=\"mediatype-selector#{i}\"><input id=\"mediatype_4\" name=\"mediatype\" type=\"radio\" value=\"4\" /><label for=\"material_types4\">児童書</label></span>\r\n" +
				"            <span class=\"mediatype-selector\" id=\"mediatype-selector#{i}\"><input id=\"mediatype_5\" name=\"mediatype\" type=\"radio\" value=\"5\" /><label for=\"material_types5\">レファレンス情報</label></span>\r\n" +
				"            <span class=\"mediatype-selector\" id=\"mediatype-selector#{i}\"><input id=\"mediatype_6\" name=\"mediatype\" type=\"radio\" value=\"6\" /><label for=\"material_types6\">デジタル資料</label></span>\r\n" +
				"            <span class=\"mediatype-selector\" id=\"mediatype-selector#{i}\"><input id=\"mediatype_7\" name=\"mediatype\" type=\"radio\" value=\"7\" /><label for=\"material_types7\">その他</label></span>\r\n" +
				"            <span class=\"mediatype-selector\" id=\"mediatype-selector#{i}\"><input id=\"mediatype_9\" name=\"mediatype\" type=\"radio\" value=\"9\" /><label for=\"material_types9\">立法情報</label></span>\r\n" +
				"      </p>\r\n" +
				"    <p class=\"guidance\"><img alt=\"簡易検索ここまで\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></p>\r\n" +
				"  </div><!-- and of #search-normal -->\r\n" +
				"</form>\r\n" +
				"  <div id=\"search-advanced\">\r\n" +
				"    <p class=\"guidance\"><img alt=\"詳細検索ここから\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></p>\r\n" +
				"    <form accept-charset=\"UTF-8\" action=\"/books/search\" id=\"search_advanced_form\" method=\"post\" name=\"searchForm\" onsubmit=\"return valid_submit_advanced();\"><input name=\"authenticity_token\" type=\"hidden\" value=\"cCtb+E5Hh/XzO3OKbc03t6vmLynhtg6K5TEji4JNp9k=\" />\r\n" +
				"    <input id=\"search_mode\" name=\"search_mode\" type=\"hidden\" value=\"advanced\" />\r\n" +
				"    \r\n" +
				"      <input id=\"filters_\" name=\"filters[]\" type=\"hidden\" value=\"3_大阪市立図書館\" />\r\n" +
				"\r\n" +
				"      <div class=\"controlarea\">\r\n" +
				"        <div class=\"adv_clear\">\r\n" +
				"          <a href=\"#\" class=\"roundbutton\">クリア</a>\r\n" +
				"        </div>\r\n" +
				"\r\n" +
				"        <table class=\"skeleton\">\r\n" +
				"          <tr>\r\n" +
				"            <th style=\"width: 90px\"><label for=\"rft.title\">タイトル</label></th>\r\n" +
				"            <td style=\"width: 140px;\">\r\n" +
				"              <input class=\"textbox\" id=\"rft.title\" name=\"rft.title\" style=\"width: 125px;\" type=\"text\" />\r\n" +
				"            </td>\r\n" +
				"            <th style=\"width: 80px;\"><label for=\"rft.au\">著者・編者</label></th>\r\n" +
				"            <td style=\"width: 140px;\">\r\n" +
				"              <input class=\"textbox\" id=\"rft.au\" name=\"rft.au\" style=\"width: 125px;\" type=\"text\" />\r\n" +
				"            </td>\r\n" +
				"            <th style=\"width: 80px;\"><label for=\"rft.pub\">出版社</label></th>\r\n" +
				"            <td style=\"width: 140px;\">\r\n" +
				"              <input class=\"textbox\" id=\"rft.pub\" name=\"rft.pub\" style=\"width: 125px;\" type=\"text\" />\r\n" +
				"            </td>\r\n" +
				"            <th style=\"width: 80px;\"><label for=\"datefrom\">出版年</label>\r\n" +
				"              <span class=\"popup-guidance\"><img alt=\"出版年は年(YYYY)のほか、年月(YYYYMM)、年月日(YYYYMMDD)の指定が可能です。&lt;br /&gt;詳しくはヘルプをご覧ください。\" height=\"13\" src=\"/images/ndl/ico_popup_help.png?1515070139\" width=\"13\" /></span>\r\n" +
				"            </th>\r\n" +
				"            <td style=\"\">\r\n" +
				"              <input class=\"textbox\" id=\"datefrom\" name=\"datefrom\" style=\"width: 60px;\" type=\"text\" />\r\n" +
				"              ～\r\n" +
				"              <input class=\"textbox\" id=\"dateto\" name=\"dateto\" style=\"width: 60px;\" type=\"text\" />\r\n" +
				"              <div class=\"valid-date\" style=\"color:#ff0000;\"></div>\r\n" +
				"            </td>\r\n" +
				"          </tr>\r\n" +
				"        </table>\r\n" +
				"        <table class=\"skeleton\">\r\n" +
				"          <tr>\r\n" +
				"            <th style=\"width: 90px;\"><label for=\"subject\">件名</label>\r\n" +
				"            <span class=\"popup-guidance\"><img alt=\"件名とはその資料が扱っているテーマを表す言葉（キーワード）です。 入力例）歴史\" height=\"13\" src=\"/images/ndl/ico_popup_help.png?1515070139\" width=\"13\" /></span></th>\r\n" +
				"            <td style=\"width: 140px;\">\r\n" +
				"              <input class=\"textbox\" id=\"subject\" name=\"subject\" style=\"width: 125px;\" type=\"text\" />\r\n" +
				"            </td>\r\n" +
				"            <th style=\"width: 80px;\"><label for=\"ndc\">分類記号</label>\r\n" +
				"            <span class=\"popup-guidance\"><img alt=\"分類記号とはその資料についての主題内容を表現する記号です。　入力例）332.1\" height=\"13\" src=\"/images/ndl/ico_popup_help.png?1515070139\" width=\"13\" /></span></th>\r\n" +
				"            <td style=\"width: 140px;\">\r\n" +
				"              <input class=\"textbox\" id=\"ndc\" name=\"ndc\" style=\"width: 125px;\" type=\"text\" value=\"699\" />\r\n" +
				"            </td>\r\n" +
				"            <th style=\"width: 80px;\"><label for=\"rft.isbn\">ISBN/ISSN</label></th>\r\n" +
				"            <td style=\"width: 140px;\">\r\n" +
				"              <input class=\"textbox\" id=\"rft.isbn\" name=\"rft.isbn\" style=\"width: 125px;\" type=\"text\" />\r\n" +
				"            </td>\r\n" +
				"            <th style=\"width: 80px;\"><label for=\"\">出版地</label>\r\n" +
				"              <span class=\"popup-guidance\"><img alt=\"都市名、国名、国名コードで検索できます。詳しくはヘルプをご覧ください。\" height=\"13\" src=\"/images/ndl/ico_popup_help.png?1515070139\" width=\"13\" /></span>\r\n" +
				"            </th>\r\n" +
				"            <td style=\"width: 220px;\">\r\n" +
				"              <input class=\"textbox\" id=\"place\" name=\"place\" style=\"width: 125px;\" type=\"text\" />\r\n" +
				"              <td style=\"width: 18px;\"></td>\r\n" +
				"            </td>\r\n" +
				"          </tr>\r\n" +
				"        </table>\r\n" +
				"\r\n" +
				"        <table class=\"skeleton\">\r\n" +
				"          <tr>\r\n" +
				"            <th style=\"width: 90px;\"><label for=\"trans\">\r\n" +
				"              <img alt=\"翻訳検索の言語のリストです。翻訳する検索言語の選択が可能です。\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /><span style=\"display:none;\">翻訳検索の言語のリストです。翻訳する検索言語の選択が可能です。</span>\r\n" +
				"              翻訳検索</label></th>\r\n" +
				"              <td>\r\n" +
				"                  <select id=\"trans\" name=\"trans\"><option value=\"\">翻訳検索しない</option>\r\n" +
				"<option value=\"ja_ko_jserver\">韓国語に翻訳</option>\r\n" +
				"<option value=\"ja_zh_jserver\">中国語に翻訳</option>\r\n" +
				"<option value=\"ja_en_jserver\">英語に翻訳</option></select>\r\n" +
				"              </td>\r\n" +
				"            </tr>\r\n" +
				"        </table>\r\n" +
				"        <table class=\"skeleton\">\r\n" +
				"          <tr>\r\n" +
				"            <th nowrap style=\"width: 90px;\">データベース</th>\r\n" +
				"            <td nowrap style=\"\">\r\n" +
				"              <script type=\"text/javascript\">\r\n" +
				"//<![CDATA[\r\n" +
				"\r\n" +
				"                  function click_dummy() {\r\n" +
				"                    for (i=0 ; i < document.getElementsByName('repository_nos[]').length ; i ++ ){\r\n" +
				"                      if (document.getElementsByName('repository_nos[]').item(i).value == 'R100000039' ||\r\n" +
				"                          document.getElementsByName('repository_nos[]').item(i).value == 'R100000040') {\r\n" +
				"                            document.getElementsByName('repository_nos[]').item(i).checked = document.getElementById('dummy_repository_nos').checked\r\n" +
				"                      }\r\n" +
				"                    }\r\n" +
				"                  }\r\n" +
				"\r\n" +
				"//]]>\r\n" +
				"</script>                     <label><input checked=\"checked\" id=\"repository_nos_\" name=\"repository_nos[]\" type=\"checkbox\" value=\"R100000002\" />国立国会図書館オンライン</label>\r\n" +
				"                     <label><input checked=\"checked\" id=\"repository_nos_\" name=\"repository_nos[]\" type=\"checkbox\" value=\"R100000001\" />公共図書館蔵書</label>\r\n" +
				"                     <label><input checked=\"checked\" id=\"repository_nos_\" name=\"repository_nos[]\" type=\"checkbox\" value=\"R000000004\" />国立国会図書館オンライン（雑誌記事索引）</label>\r\n" +
				"                     <label><input checked=\"checked\" id=\"dummy_repository_nos\" name=\"dummy_repository_nos\" onclick=\"click_dummy();\" type=\"checkbox\" value=\"dummy\" />NDLデジタルコレクション</label>\r\n" +
				"                     <div style=\"display:none\">\r\n" +
				"                     <label><input checked=\"checked\" id=\"repository_nos_\" name=\"repository_nos[]\" type=\"checkbox\" value=\"R100000039\" />国立国会図書館デジタルコレクション</label>\r\n" +
				"                     </div>\r\n" +
				"                     <div style=\"display:none\">\r\n" +
				"                     <label><input checked=\"checked\" id=\"repository_nos_\" name=\"repository_nos[]\" type=\"checkbox\" value=\"R100000040\" />国立国会図書館デジタルコレクション（電子書籍・電子雑誌）</label>\r\n" +
				"                     </div>\r\n" +
				"              <label><input checked=\"checked\" id=\"repository_nos_\" name=\"repository_nos[]\" type=\"checkbox\" value=\"other\" />その他</label>\r\n" +
				"              <input type=\"button\" class=\"release4\" value=すべて選択/解除>\r\n" +
				"            </td>\r\n" +
				"          </tr>\r\n" +
				"        </table>\r\n" +
				"        <table class=\"skeleton\">\r\n" +
				"          <tr>\r\n" +
				"            <th style=\"width: 90px;\">資料種別</th>\r\n" +
				"            <td style=\"\">\r\n" +
				"                <label><input checked=\"checked\" id=\"mediatypes_\" name=\"mediatypes[]\" type=\"checkbox\" value=\"1\" />本</label>\r\n" +
				"                <label><input checked=\"checked\" id=\"mediatypes_\" name=\"mediatypes[]\" type=\"checkbox\" value=\"2\" />記事・論文</label>\r\n" +
				"                <label><input checked=\"checked\" id=\"mediatypes_\" name=\"mediatypes[]\" type=\"checkbox\" value=\"3\" />新聞</label>\r\n" +
				"                <label><input checked=\"checked\" id=\"mediatypes_\" name=\"mediatypes[]\" type=\"checkbox\" value=\"4\" />児童書</label>\r\n" +
				"                <label><input checked=\"checked\" id=\"mediatypes_\" name=\"mediatypes[]\" type=\"checkbox\" value=\"5\" />レファレンス情報</label>\r\n" +
				"                <label><input checked=\"checked\" id=\"mediatypes_\" name=\"mediatypes[]\" type=\"checkbox\" value=\"6\" />デジタル資料</label>\r\n" +
				"                <label><input checked=\"checked\" id=\"mediatypes_\" name=\"mediatypes[]\" type=\"checkbox\" value=\"7\" />その他</label>\r\n" +
				"                <label><input checked=\"checked\" id=\"mediatypes_\" name=\"mediatypes[]\" type=\"checkbox\" value=\"9\" />立法情報</label>\r\n" +
				"              <input type=\"button\" class=\"release\" value=すべて選択/解除>\r\n" +
				"            </td>\r\n" +
				"          </tr>\r\n" +
				"        </table>\r\n" +
				"        <table class=\"skeleton\">\r\n" +
				"          <tr>\r\n" +
				"            <th style=\"width: 90px;\">所蔵館</th>\r\n" +
				"            <td>\r\n" +
				"              <label><input checked=\"checked\" id=\"libraries_\" name=\"libraries[]\" type=\"checkbox\" value=\"1\" />国立国会図書館</label>\r\n" +
				"              <label><input checked=\"checked\" id=\"libraries_\" name=\"libraries[]\" type=\"checkbox\" value=\"2\" />他機関</label>\r\n" +
				"              <dl class=\"media-option\">\r\n" +
				"                <dt>連携先</dt>\r\n" +
				"                <dd>\r\n" +
				"                    <input id=\"do_remote_search_999\" name=\"do_remote_search\" type=\"checkbox\" value=\"true\" checked=\"checked\" />\r\n" +
				"                  <label for=\"do_remote_search_999\">すべての<a href=\"/information/target/\" target=\"_blank\">連携先</a>を検索する</label>\r\n" +
				"                  <span class=\"popup-guidance\"><img alt=\"チェックすると、検索結果表示に時間がかかるデータベースも含めて検索します。\" height=\"13\" src=\"/images/ndl/ico_popup_help.png?1515070139\" width=\"13\" /></span>\r\n" +
				"                </dd>\r\n" +
				"              </dl>\r\n" +
				"            </td>\r\n" +
				"          </tr>\r\n" +
				"        </table>\r\n" +
				"      </div>\r\n" +
				"      <div class=\"submitarea\">\r\n" +
				"        <input class=\"searchbutton\" id=\"searchbutton_advanced\" name=\"commit\" onclick=\"valid_date();\" type=\"button\" value=\"検索\" />\r\n" +
				"      </div>\r\n" +
				"</form>    <p class=\"guidance\"><img alt=\"詳細検索ここまで\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></p>\r\n" +
				"  </div>\r\n" +
				"  <div id=\"modal\" style=\"display:none;\">\r\n" +
				"    <p>出版年に「年月」「年月日」を指定した場合は指定の桁数未満の出版年を持つ書誌がヒットしません。詳しくはヘルプをご覧ください。</p><br>\r\n" +
				"    <p>\r\n" +
				"      <label><input id=\"date_dialog\" type=\"checkbox\" checked >今後このメッセージを表示しない</label>\r\n" +
				"    </p>\r\n" +
				"  </div><!-- end of #search-advanced -->\r\n" +
				"\r\n" +
				"  <div id=\"search-handicapped\">\r\n" +
				"    <p class=\"guidance\"><img alt=\"障害者向け資料検索ここから\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></p>\r\n" +
				"    <form accept-charset=\"UTF-8\" action=\"/books/search\" id=\"search_handicapped_form\" method=\"post\" name=\"searchForm\"><input name=\"authenticity_token\" type=\"hidden\" value=\"cCtb+E5Hh/XzO3OKbc03t6vmLynhtg6K5TEji4JNp9k=\" />\r\n" +
				"    <input id=\"search_mode\" name=\"search_mode\" type=\"hidden\" value=\"handicapped\" />\r\n" +
				"    <input id=\"mediatypes_\" name=\"mediatypes[]\" type=\"hidden\" value=\"8\" />\r\n" +
				"    \r\n" +
				"      <input id=\"filters_\" name=\"filters[]\" type=\"hidden\" value=\"3_大阪市立図書館\" />\r\n" +
				"\r\n" +
				"    <div class=\"controlarea\">\r\n" +
				"      <div class=\"handi_clear\">\r\n" +
				"        <a href=\"#\" class=\"roundbutton\">クリア</a>\r\n" +
				"      </div>\r\n" +
				"      <table class=\"skeleton\"  style=\"margin-bottom: 10px;\">\r\n" +
				"        <tr style=\"float: left;\">\r\n" +
				"        <!-- <tr> -->\r\n" +
				"          <th style=\"width: 85px\"><label for=\"any\">キーワード</label></th>\r\n" +
				"          <td style=\"width: 450px;\">\r\n" +
				"            <input class=\"textbox\" id=\"any\" name=\"any\" style=\"width: 445px; height:20px;\" type=\"text\" value=\"\" />\r\n" +
				"          </td>\r\n" +
				"        </tr>\r\n" +
				"      </table>\r\n" +
				"      <table class=\"skeleton\">\r\n" +
				"        <tr>\r\n" +
				"          <th style=\"width: 85px\"><label for=\"rft.title2\">タイトル</label></th>\r\n" +
				"          <td style=\"width: 140px;\">\r\n" +
				"            <input class=\"textbox\" id=\"rft.title2\" name=\"rft.title\" style=\"width: 125px;\" type=\"text\" value=\"\" />\r\n" +
				"          </td>\r\n" +
				"          <th style=\"width: 80px;\"><label for=\"rft.au2\">著者、編者等</label></th>\r\n" +
				"          <td style=\"width: 140px;\">\r\n" +
				"            <input class=\"textbox\" id=\"rft.au2\" name=\"rft.au\" style=\"width: 125px;\" type=\"text\" value=\"\" />\r\n" +
				"          </td>\r\n" +
				"          <th style=\"width: 85px;\"><label for=\"org_pub2\">原本出版者ほか</label></th>\r\n" +
				"          <td style=\"width: 140px;\">\r\n" +
				"            <input class=\"textbox\" id=\"org_pub2\" name=\"org_pub\" style=\"width: 125px;\" type=\"text\" value=\"\" />\r\n" +
				"          </td>\r\n" +
				"          <th style=\"width: 80px;\"><label for=\"datefrom2\">原本出版年</label></th>\r\n" +
				"          <td style=\"width: 150px;\">\r\n" +
				"            <input class=\"textbox\" id=\"datefrom2\" name=\"datefrom\" style=\"width: 40px;\" type=\"text\" value=\"\" />\r\n" +
				"            年～\r\n" +
				"            <input class=\"textbox\" id=\"dateto2\" name=\"dateto\" style=\"width: 40px;\" type=\"text\" value=\"\" />\r\n" +
				"            年\r\n" +
				"          </td>\r\n" +
				"        </tr>\r\n" +
				"      </table>\r\n" +
				"      <table class=\"skeleton\">\r\n" +
				"        <tr>\r\n" +
				"          <th style=\"width: 85px;\"><label for=\"subject2\">件名</label>\r\n" +
				"          <span class=\"popup-guidance\"><img alt=\"件名とはその資料が扱っているテーマを表す言葉（キーワード）です。 入力例）歴史\" height=\"13\" src=\"/images/ndl/ico_popup_help.png?1515070139\" width=\"13\" /></span></th>\r\n" +
				"          <td style=\"width: 140px;\">\r\n" +
				"            <input class=\"textbox\" id=\"subject2\" name=\"subject\" style=\"width: 125px;\" type=\"text\" value=\"\" />\r\n" +
				"          </td>\r\n" +
				"          <th style=\"width: 80px;\"><label for=\"ndc2\">分類</label>\r\n" +
				"          <span class=\"popup-guidance\"><img alt=\"分類とはその資料についての主題内容を表現する記号です。　入力例）332.1\" height=\"13\" src=\"/images/ndl/ico_popup_help.png?1515070139\" width=\"13\" /></span></th>\r\n" +
				"          <td style=\"width: 140px;\">\r\n" +
				"            <input class=\"textbox\" id=\"ndc2\" name=\"ndc\" style=\"width: 125px;\" type=\"text\" value=\"\" />\r\n" +
				"          </td>\r\n" +
				"          <th style=\"width: 85px;\"><label for=\"rft.isbn2\">ISBN、ISSN</label></th>\r\n" +
				"          <td style=\"width: 140px;\">\r\n" +
				"            <input class=\"textbox\" id=\"rft.isbn2\" name=\"rft.isbn\" style=\"width: 125px;\" type=\"text\" value=\"\" />\r\n" +
				"          </td>\r\n" +
				"          <th style=\"width: 80px;\"><label for=\"digital_pub2\">製作者、所蔵館</label></th>\r\n" +
				"          <td style=\"width: 150px;\">\r\n" +
				"            <input class=\"textbox\" id=\"digital_pub2\" name=\"digital_pub\" style=\"width: 125px;\" type=\"text\" value=\"\" />\r\n" +
				"          </td>\r\n" +
				"        </tr>\r\n" +
				"      </table>\r\n" +
				"      <table class=\"skeleton\">\r\n" +
				"        <tr>\r\n" +
				"          <th style=\"width: 85px;\">資料種別</th>\r\n" +
				"          <td style=\"\">\r\n" +
				"              <label><input checked=\"checked\" id=\"materialtypes_\" name=\"materialtypes[]\" type=\"checkbox\" value=\"Braille\" />点字</label>\r\n" +
				"              <label><input checked=\"checked\" id=\"materialtypes_\" name=\"materialtypes[]\" type=\"checkbox\" value=\"DAISY\" />DAISY・テキストデータ</label>\r\n" +
				"              <label><input checked=\"checked\" id=\"materialtypes_\" name=\"materialtypes[]\" type=\"checkbox\" value=\"AudioBookInSoundDisk\" />録音図書（DVD、CD）</label>\r\n" +
				"              <label><input checked=\"checked\" id=\"materialtypes_\" name=\"materialtypes[]\" type=\"checkbox\" value=\"AudioBookInSoundTape\" />録音図書（カセットテープ）</label>\r\n" +
				"              <label><input checked=\"checked\" id=\"materialtypes_\" name=\"materialtypes[]\" type=\"checkbox\" value=\"LargePrint\" />大活字</label>\r\n" +
				"            <input type=\"button\" class=\"release2\" value=すべて選択/解除 >\r\n" +
				"          </td>\r\n" +
				"        </tr>\r\n" +
				"      </table>\r\n" +
				"    </div>\r\n" +
				"    <div class=\"submitarea\">\r\n" +
				"      <input class=\"searchbutton\" name=\"commit\" type=\"submit\" value=\"検索\" />\r\n" +
				"    </div>\r\n" +
				"    <p class=\"guidance\"><img alt=\"障害者向け資料検索ここまで\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></p>\r\n" +
				"</form>  </div><!-- end of #search-handicapped -->\r\n" +
				"</div><!-- end of .tabs-search -->\r\n" +
				"\r\n" +
				"  <script type=\"text/javascript\">\r\n" +
				"//<![CDATA[\r\n" +
				"$('.tabs-search').tabs({selected:1});\r\n" +
				"//]]>\r\n" +
				"</script>\r\n" +
				"\r\n" +
				"<script type=\"text/javascript\">\r\n" +
				"//<![CDATA[\r\n" +
				"	// 「すべて選択/解除」ボタン定義\r\n" +
				"	$(\"input.release2\").toggle(\r\n" +
				"		function(){\r\n" +
				"			$(this).parent().children(\"label\").children(\"input\").attr(\"checked\", \"\");\r\n" +
				"			$(\"input.release3\").parent().children(\"label\").children(\"input\").attr(\"checked\", \"\");\r\n" +
				"		},\r\n" +
				"		function(){\r\n" +
				"			$(this).parent().children(\"label\").children(\"input\").attr(\"checked\", \"checked\");\r\n" +
				"			$(\"input.release3\").parent().children(\"label\").children(\"input\").attr(\"checked\", \"checked\");\r\n" +
				"		}\r\n" +
				"	);\r\n" +
				"\r\n" +
				"	// 「すべて選択/解除」ボタン定義(データベース)\r\n" +
				"	$(\"input.release4\").toggle(\r\n" +
				"		function(){\r\n" +
				"			$(this).parent().children(\"label\").children(\"input\").attr(\"checked\", \"\");\r\n" +
				"			click_dummy();\r\n" +
				"		},\r\n" +
				"		function(){\r\n" +
				"			$(this).parent().children(\"label\").children(\"input\").attr(\"checked\", \"checked\");\r\n" +
				"			click_dummy();\r\n" +
				"		}\r\n" +
				"	);\r\n" +
				"	\r\n" +
				"  $(\"#do_remote_search_999\").click(function(){\r\n" +
				"    if($(\"#do_remote_search_999\").val() == \"true\"){\r\n" +
				"      $(\"#do_remote_search_999\").val(\"\");\r\n" +
				"    }else{\r\n" +
				"      $(\"#do_remote_search_999\").val(\"true\");\r\n" +
				"    }\r\n" +
				"  });\r\n" +
				"  $(\"div#search-advanced table.skeleton\").css(\"width\", \"1000px\")\r\n" +
				"\r\n" +
				"  $('#search_advanced_form input').keypress(function(e){\r\n" +
				"    if (e.keyCode == 13) {\r\n" +
				"      valid_date();\r\n" +
				"    }\r\n" +
				"  });\r\n" +
				"\r\n" +
				"//]]>\r\n" +
				"</script>\r\n" +
				"\r\n" +
				"<div id=\"resultlist\">\r\n" +
				"  <div id=\"resultlist_left-wrapper\">\r\n" +
				"    <div id=\"listcontent\">\r\n" +
				"        <div id=\"resultheaderwrapper\" class=\"dropshadow-top\">\r\n" +
				"\r\n" +
				"  <span id=\"cross_search_progress\">\r\n" +
				"</span>\r\n" +
				"\r\n" +
				"  <div id=\"resultheader\">\r\n" +
				"      <h1 class=\"result-title\">\r\n" +
				"      検索結果一覧\r\n" +
				"    </h1>\r\n" +
				"    <p class=\"result-stats\">\r\n" +
				"      検索結果<strong>2544</strong>件中<strong>1</strong>から<strong>100</strong>件を表示\r\n" +
				"    </p>\r\n" +
				"    <div class=\"option-control-wrapper\">\r\n" +
				"      <p class=\"guidance\"><label for=\"sort\"><img alt=\"検索結果表示順のリストです。検索結果表示順の種類の選択が可能です。\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /><span style=\"display:none;\">検索結果表示順のリストです。検索結果表示順の種類の選択が可能です。</span></label></p>\r\n" +
				"        <form accept-charset=\"UTF-8\" action=\"/books\" method=\"get\">                <input id=\"filters_\" name=\"filters[]\" type=\"hidden\" value=\"3_大阪市立図書館\" />              <input id=\"ar\" name=\"ar\" type=\"hidden\" value=\"4e1f\" />              <input id=\"except_repository_nos\" name=\"except_repository_nos\" type=\"hidden\" value=\"R100000038 R100000049 R100000073\" />              <input id=\"do_remote_search\" name=\"do_remote_search\" type=\"hidden\" value=\"true\" />              <input id=\"display\" name=\"display\" type=\"hidden\" value=\"thumbnail\" />              <input id=\"ndc\" name=\"ndc\" type=\"hidden\" value=\"699\" />              <input id=\"search_mode\" name=\"search_mode\" type=\"hidden\" value=\"advanced\" />          <select id=\"sort\" name=\"sort\"><option value=\"df\">適合度順</option>\r\n" +
				"<option value=\"ud\">新しい順</option>\r\n" +
				"<option value=\"ua\">古い順</option>\r\n" +
				"<option value=\"ya\">タイトル（昇順）</option>\r\n" +
				"<option value=\"yd\">タイトル（降順）</option>\r\n" +
				"<option value=\"da\">データベース順</option></select>\r\n" +
				"          <input class=\"actionbutton \" onclick=\"change_page_with_sort_type(sort);\" type=\"button\" value=\"並び替え\" />\r\n" +
				"</form>        <div class=\"option-control option-control-thumbnail \">\r\n" +
				"            <span class=\"option-control-label\">表示切替</span>\r\n" +
				"            <a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;ndc=699&amp;search_mode=advanced\" class=\"option-control-box option-control-list\">一覧</a><a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced\" class=\"option-control-box option-control-thumbnail\">書影</a>\r\n" +
				"        </div>\r\n" +
				"    </div>\r\n" +
				"    \r\n" +
				"    <div class=\"optional-select\">\r\n" +
				"    </div>\r\n" +
				"    <p class=\"guidance\"><img alt=\"ページジャンプ\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></p>\r\n" +
				"    <ul class=\"pagingnav\" style=\"margin-top:1px;\">\r\n" +
				"<li><span class=\"larrow larrow_d\">前のページに戻る</span></li>\r\n" +
				"<li><strong>1</strong></li>\r\n" +
				"<li><a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;page=2&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced\">2</a></li>\r\n" +
				"<li><a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;page=3&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced\">3</a></li>\r\n" +
				"<li><a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;page=4&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced\">4</a></li>\r\n" +
				"<li><a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;page=5&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced\">5</a></li>\r\n" +
				"<li><a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;page=2&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced\" class=\"rarrow\">次のページに進む</a></li>\r\n" +
				"</ul>\r\n" +
				"      \r\n" +
				"\r\n" +
				"</div><!-- end of div#resultheader -->\r\n" +
				"</div><!-- end of div#resultheaderwrapper -->\r\n" +
				"\r\n" +
				"            <div id=\"thumbnail-result-wrapper\">\r\n" +
				"  <ul>\r\n" +
				"      <div id=\"list_item_0\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612946-00\">放送学序説</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ総合放送文化研究所放送学研究室／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1975\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_1\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005745933-00\">テレビとラジオのはなし</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      野田　一郎／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        ポプラ社\r\n" +
				"        1981\r\n" +
				"        (新・おはなし社会科 ; １９)\r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_2\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005745934-00\">ユカはディレクター : テレビとラジオのはなし</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      野田　一郎／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        ポプラ社\r\n" +
				"        1973\r\n" +
				"        (おはなし社会科シリーズ ; １１)\r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_3\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_child.gif';\" src=\"/images/ndl/ico_class_thumbnail_child.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005745935-00\">アナウンサー : 信頼される伝え手めざす</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      新堀　俊明／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        あいうえお館\r\n" +
				"        1985\r\n" +
				"        (はたらく姿に学ぶ仕事日記)\r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_4\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010857346-00\">シンポジウム検証戦後放送</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      朝日放送株式会社戦後５０年企画ＡＢＣ推進委員会／編集\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        朝日放送株式会社戦後５０年企画ＡＢＣ推進委員会\r\n" +
				"        1996\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_5\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010860611-00\">ＮＨＫ会長海老沢勝二が語るデジタル公共放送論</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      月刊ニューメディア編集部／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        ニューメディア\r\n" +
				"        2000\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_6\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010901717-00\">メディアの黙示録 : テレビ局再編！</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      西　正／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        角川書店\r\n" +
				"        2003\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_7\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010904557-00\">テレビスポーツ５０年 : オリンピックとテレビの発展</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      杉山　茂／著,角川インタラクティブ・メディア／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        角川インタラクティブ・メディア\r\n" +
				"        2003\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_8\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I011079752-00\">映画監督・ＴＶディレクターになるには</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      佐藤　忠男／編著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        ぺりかん社\r\n" +
				"        1979\r\n" +
				"        (なるにはＢＯＯＫＳ ; ９)\r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_9\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I011164581-00\">あなたの知らない世界</a>\r\n" +
				"        <span style=\"font-weight:normal;\">１１</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      新倉　イワオ／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本テレビ\r\n" +
				"        1986\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_10\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I011164582-00\">あなたの知らない世界</a>\r\n" +
				"        <span style=\"font-weight:normal;\">１０</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      新倉　イワオ／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本テレビ\r\n" +
				"        1985\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_11\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I011164583-00\">あなたの知らない世界</a>\r\n" +
				"        <span style=\"font-weight:normal;\">９</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      新倉　イワオ／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本テレビ\r\n" +
				"        1985\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_12\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I011164584-00\">あなたの知らない世界</a>\r\n" +
				"        <span style=\"font-weight:normal;\">８</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      新倉　イワオ／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本テレビ\r\n" +
				"        1984\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_13\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I011164585-00\">あなたの知らない世界</a>\r\n" +
				"        <span style=\"font-weight:normal;\">７</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      新倉　イワオ／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本テレビ\r\n" +
				"        1984\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_14\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I011164586-00\">あなたの知らない世界</a>\r\n" +
				"        <span style=\"font-weight:normal;\">６</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      新倉　イワオ／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本テレビ\r\n" +
				"        1983\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_15\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I011164589-00\">あなたの知らない世界</a>\r\n" +
				"        <span style=\"font-weight:normal;\">続々</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      新倉　イワオ／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本テレビ\r\n" +
				"        1981\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_16\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I011164590-00\">あなたの知らない世界</a>\r\n" +
				"        <span style=\"font-weight:normal;\">続</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      新倉　イワオ／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本テレビ\r\n" +
				"        1981\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_17\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I011174937-00\">一葦の記 : 私の民放営業三十年</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      諏訪　博／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        ＴＢＳブリタニカ\r\n" +
				"        1981\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_18\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I011496437-00\">放送ビッグバン</a>\r\n" +
				"        <span style=\"font-weight:normal;\">４</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      西　正／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日刊工業新聞社\r\n" +
				"        2000\r\n" +
				"        (Ｂ＆Ｔブックス)\r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_19\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I012351064-00\">テレビ放送ハンドブック</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      石原　裕市郎／共著,新井　清治／共著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        ダヴィッド社\r\n" +
				"        1979\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_20\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I012553630-00\">不思議の箱のテレビ考</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      小中　陽太郎／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        駸々堂出版\r\n" +
				"        1984\r\n" +
				"        (戦後世代の芸能史)\r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_21\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I012656058-00\">放送ビッグバン</a>\r\n" +
				"        <span style=\"font-weight:normal;\">５</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      西　正／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日刊工業新聞社\r\n" +
				"        2001\r\n" +
				"        (Ｂ＆Ｔブックス)\r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_22\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I020179953-00\">“第三のテレビ”ＣＡＴＶ : Ｃａｂｌｅ　ｔｅｌｅｖｉｓｉｏｎ</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      高橋信三／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        現代ジャーナリズム出版会\r\n" +
				"        1970\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_23\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I021753860-00\">合冊アーカイブス・カフェ : ライツ・アーカイブスセンター月刊通信</a>\r\n" +
				"        <span style=\"font-weight:normal;\">Ｖｏｌ．１</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      \r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        ＮＨＫライツ・アーカイブスセンター\r\n" +
				"        2009\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_24\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I021805268-00\">さだまさしのセイヤング</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      さだ　まさし／編著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        自由書館\r\n" +
				"        1983\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_25\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I023232987-00\">テレビ放送事故＆ハプニング : 笑えるけど超ヤバい！</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      マイケル宮内 著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        廣済堂出版\r\n" +
				"        2007\r\n" +
				"        (廣済堂ペーパーバックス)\r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_26\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I026148465-00\">テレビプロデューサー入門</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      加登川幸太郎／［ほか］執筆\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        四季社\r\n" +
				"        1960\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_27\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I052137954-00\">テレビ・ラジオ番組個人視聴率調査全国結果表</a>\r\n" +
				"        <span style=\"font-weight:normal;\">2006-6</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      \r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        NHK放送文化研究所(世論調査)\r\n" +
				"        \r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_28\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I052354906-00\">いつもラジオと一緒 : ABCラジオ創立60周年記念ブック</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      \r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        プラネットバルン\r\n" +
				"        2011-03\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_29\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_child.gif';\" src=\"/images/ndl/ico_class_thumbnail_child.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I052677268-00\">声優物語 : Dream girl</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      内村 かなめ/著,白倉 由美/著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        光文社\r\n" +
				"        1997-05\r\n" +
				"        (少年王)\r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_30\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I052752791-00\">テレビ・ラジオ番組個人視聴率調査全国結果表</a>\r\n" +
				"        <span style=\"font-weight:normal;\">1998-11</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      \r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        放送文化研究所(世論調査)\r\n" +
				"        \r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_31\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I052794999-00\">今さら聞けないケーブルテレビ＆衛星用語集</a>\r\n" +
				"        <span style=\"font-weight:normal;\">2000</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      月刊『サテライトマガジン』編集部/編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        サテライトマガジン社\r\n" +
				"        2000-01\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_32\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I053598692-00\">YTV REPORT 別冊 DATA-BOOK</a>\r\n" +
				"        <span style=\"font-weight:normal;\">1971</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      [読売テレビ放送株式会社/編]\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        読売テレビ放送\r\n" +
				"        1971-09\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_33\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I053598693-00\">YTV REPORT 別冊 DATA-BOOK</a>\r\n" +
				"        <span style=\"font-weight:normal;\">1973</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      [読売テレビ放送株式会社/編]\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        [読売テレビ放送]\r\n" +
				"        1973\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_34\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I053665904-00\">世界のラジオとテレビジョン</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会/編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1965-03\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_35\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I003902686-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’９１</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化研究所 編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1991\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_36\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I003913271-00\">ＮＨＫデ−タブック世界の放送 : テレビ・ラジオ・衛星・ＣＡＴＶ</a>\r\n" +
				"        <span style=\"font-weight:normal;\">１９９０</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化研究所 編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1990\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_37\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I003930172-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’９２</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化研究所 編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1992\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_38\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I003960471-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’９３</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化研究所 編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1993\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_39\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I003965209-00\">ＮＨＫデ−タブック世界の放送 : テレビ・ラジオ・衛星・ＣＡＴＶ</a>\r\n" +
				"        <span style=\"font-weight:normal;\">１９９４</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化研究所 編集\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1994\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_40\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I003981969-00\">ＮＨＫデ−タブック世界の放送 : テレビ・ラジオ・衛星・ＣＡＴＶ</a>\r\n" +
				"        <span style=\"font-weight:normal;\">１９９６</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化研究所 編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1996\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_41\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I003984447-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’９６</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化研究所 編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1996\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_42\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I003993447-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’９７</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化研究所 編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1997\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_43\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I003998496-00\">ＮＨＫデ−タブック世界の放送 : テレビ・ラジオ・衛星・ＣＡＴＶ</a>\r\n" +
				"        <span style=\"font-weight:normal;\">１９９８</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化研究所 編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1998\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_44\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I004003055-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’９８</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化研究所 編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1998\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_45\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I004006988-00\">ＮＨＫデ−タブック世界の放送</a>\r\n" +
				"        <span style=\"font-weight:normal;\">１９９９</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化研究所 編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1999\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_46\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I004065278-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’９９</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化研究所 編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1999\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_47\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005576913-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２０００</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編集\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2000\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_48\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005586853-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２００１</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編集\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2001\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_49\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612920-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’６９</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1969\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_50\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612921-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’７０</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1970\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_51\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612922-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’７１</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1971\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_52\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612923-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’７２</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1972\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_53\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612924-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’７３</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編集\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1973\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_54\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612925-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’７４</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編集\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1974\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_55\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612926-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’７５</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編集\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1975\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_56\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612927-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">７６</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／［著］\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1976\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_57\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612928-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’７７</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編集\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1977\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_58\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612929-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">７８</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1978\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_59\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612930-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’７９</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1979\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_60\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612931-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’８０</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1980\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_61\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612932-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’８１</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1981\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_62\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612937-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’８６</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化調査研究所放送情報調査部／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1986\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_63\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612938-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’８７</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化調査研究所放送情報調査部／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1987\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_64\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612939-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’８８</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化調査研究所放送情報調査部／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1988\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_65\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612949-00\">テレビを創った人びと : 巨大テレビにした人間群像</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      志賀　信夫／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本工業新聞社\r\n" +
				"        1979\r\n" +
				"        (大手町ブックスの本)\r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_66\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612950-00\">テレビを創った人びと : 巨大テレビにした人間群像</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      志賀　信夫／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本工業新聞社\r\n" +
				"        1981\r\n" +
				"        (大手町ブックスの本)\r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_67\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005612972-00\">テレビ・ラジオ番組視聴率調査全国結果表</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      \r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        ＮＨＫ世論調査部\r\n" +
				"        1990\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_68\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005643473-00\">日本のテレビ企業 : ブラウン管の奥の人間ドラマ</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      落合　孝幸／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        実業之日本社\r\n" +
				"        1980\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_69\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005716996-00\">ＮＨＫ報道の５０年 : 激動の昭和とともに</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      「ＮＨＫ報道の記録」刊行委員会／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        近藤書店\r\n" +
				"        1988\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_70\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005717050-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’８９</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化調査研究所放送情報調査部／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1989\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_71\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005790556-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’９４</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化研究所放送情報調査部／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1994\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_72\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005802143-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">’９５</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会放送文化研究所放送情報調査部／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1995\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_73\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005856472-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２００２</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編集\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2002\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_74\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005866593-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２００３</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編集\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2003\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_75\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005877781-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２００４</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編集\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2004\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_76\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005890000-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２００５</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編集\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2005\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_77\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005894291-00\">ＮＨＫデータブック世界の放送</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２００６</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2006\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_78\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005901319-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２００６</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編集\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2006\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_79\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005905384-00\">ＮＨＫデータブック世界の放送</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２００７</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2007\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_80\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005909218-00\">新日本紀行 : ＮＨＫは何を伝えてきたか</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      \r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送協会\r\n" +
				"        2007\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_81\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005915237-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２００７</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編集\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2007\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_82\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005918507-00\">ＮＨＫデータブック世界の放送</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２００８</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2008\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_83\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005937204-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２００９</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2009\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_84\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005941861-00\">ＮＨＫデータブック世界の放送</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２０１０</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2010\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_85\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I005955568-00\">ＮＨＫデータブック世界の放送</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２０１１</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        ＮＨＫ出版\r\n" +
				"        2011\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_86\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010577879-00\">放送受信契約数統計要覧</a>\r\n" +
				"        <span style=\"font-weight:normal;\">平成７年度</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1996\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_87\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010583807-00\">放送受信契約数統計要覧</a>\r\n" +
				"        <span style=\"font-weight:normal;\">平成８年度</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1997\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_88\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010585341-00\">放送受信契約数統計要覧</a>\r\n" +
				"        <span style=\"font-weight:normal;\">平成６年度</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1995\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_89\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010603123-00\">放送受信契約数統計要覧</a>\r\n" +
				"        <span style=\"font-weight:normal;\">平成９年度</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1998\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_90\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010823586-00\">放送受信契約数統計要覧</a>\r\n" +
				"        <span style=\"font-weight:normal;\">平成４年度</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1993\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_91\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_child.gif';\" src=\"/images/ndl/ico_class_thumbnail_child.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010844860-00\">放送にかかわる仕事 : アナウンサー　放送技術者　ＣＭ制作者</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ２１００００６５４９２００００\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        ほるぷ出版\r\n" +
				"        1999\r\n" +
				"        (知りたい！なりたい！職業ガイド)\r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_92\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010848515-00\">放送受信契約数統計要覧</a>\r\n" +
				"        <span style=\"font-weight:normal;\">平成１０年度</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        1999\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_93\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010856729-00\">ＮＨＫデータブック世界の放送</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２０００</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2000\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_94\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010864073-00\">放送受信契約数統計要覧</a>\r\n" +
				"        <span style=\"font-weight:normal;\">平成１１年度</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2000\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_95\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010884498-00\">放送受信契約数統計要覧</a>\r\n" +
				"        <span style=\"font-weight:normal;\">平成１２年度</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      日本放送協会／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2001\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_96\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010892490-00\">ＮＨＫデータブック世界の放送</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２００２</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2002\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_97\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010912799-00\">ＮＨＫデータブック世界の放送</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２００４</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2004\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_98\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010934806-00\">天晴れ！筑紫哲也ＮＥＷＳ２３</a>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      中宮　崇／著\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        文芸春秋\r\n" +
				"        2006\r\n" +
				"        (文春新書 ; ４９４)\r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div><div id=\"list_item_99\" class=\"type-thumbnail\">\r\n" +
				"          <li class=\"item_result item_book itempadding\" style=\"\">\r\n" +
				"  <div class=\"material_image\">\r\n" +
				"    <img alt=\"資料種別\" height=\"115\" onError=\"this.onerror = null;this.src='/images/ndl/ico_class_thumbnail_book.gif';\" src=\"/images/ndl/ico_class_thumbnail_book.gif?1515070139\" width=\"115\" />\r\n" +
				"  </div>\r\n" +
				"  <div class=\"material_category\">\r\n" +
				"      図書\r\n" +
				"  </div>\r\n" +
				"  <div class=\"item_summarywrapper\">\r\n" +
				"    <h3>\r\n" +
				"      <a href=\"https://iss.ndl.go.jp/books/R100000001-I010969785-00\">ＮＨＫ年鑑</a>\r\n" +
				"        <span style=\"font-weight:normal;\">２００８</span>\r\n" +
				"    </h3>\r\n" +
				"    <p>\r\n" +
				"      ＮＨＫ放送文化研究所／編\r\n" +
				"      <span style=\"padding-left:5px;\">\r\n" +
				"        日本放送出版協会\r\n" +
				"        2008\r\n" +
				"        \r\n" +
				"      </span>\r\n" +
				"    </p>\r\n" +
				"  </div>\r\n" +
				"</li>\r\n" +
				"\r\n" +
				"        </div>\r\n" +
				"  </ul>\r\n" +
				"  </div>\r\n" +
				"\r\n" +
				"\r\n" +
				"        <div id=\"resultfooterwrapper\">\r\n" +
				"          <p class=\"guidance\"><a href=\"#search-guidance\">再検索する</a></p>\r\n" +
				"          <div id=\"resultfooter\">\r\n" +
				"            <p class=\"guidance\"><img alt=\"ページジャンプ\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></p>\r\n" +
				"            <ul class=\"pagingnav\" style=\"margin-top:1px;\">\r\n" +
				"<li><span class=\"larrow larrow_d\">前のページに戻る</span></li>\r\n" +
				"<li><strong>1</strong></li>\r\n" +
				"<li><a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;page=2&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced\">2</a></li>\r\n" +
				"<li><a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;page=3&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced\">3</a></li>\r\n" +
				"<li><a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;page=4&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced\">4</a></li>\r\n" +
				"<li><a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;page=5&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced\">5</a></li>\r\n" +
				"<li><a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;page=2&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced\" class=\"rarrow\">次のページに進む</a></li>\r\n" +
				"</ul>\r\n" +
				"            <p class=\"pagetop\"><a href=\"#PTOP\">ページトップに戻る</a></p>\r\n" +
				"          </div><!-- end of div#resultfooter -->\r\n" +
				"        </div><!-- end of div#resultfooterwrapper -->\r\n" +
				"      <p class=\"guidance\"><img alt=\"検索結果一覧ここまで\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></p>\r\n" +
				"    </div><!-- end of div#listcontent -->\r\n" +
				"\r\n" +
				"    <div id=\"facet\">\r\n" +
				"      <div class=\"facet-wrapper\">\r\n" +
				"          <h2 class=\"mainlabel\">\r\n" +
				"            検索結果の絞り込み\r\n" +
				"          </h2>\r\n" +
				"\r\n" +
				"          <ul class=\"filteringby\">\r\n" +
				"              <li><span>\r\n" +
				"                  大阪市立図書館\r\n" +
				"                </span><a href=\"/books?&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">解除</a></li>\r\n" +
				"          </ul>\r\n" +
				"\r\n" +
				"            <div id=\"facet_group_ui_media_type_sm\" class=\"subgroup\">\r\n" +
				"                <h3 class=\"sublabel\">資料種別</h3>\r\n" +
				"  <ul class=\"sub-ul\">\r\n" +
				"  <li>  <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=1_1&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">本</a>  (2544件)\r\n" +
				"</li>  <li>  <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=1_4&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">児童書</a>  (114件)\r\n" +
				"</li>  </ul>\r\n" +
				"            </div>\r\n" +
				"            <div id=\"facet_group_repository_no_sm\" class=\"subgroup\">\r\n" +
				"              <p class=\"guidance\" id=\"facet_group_repository_no_shortcut\"><a href=\"#\"><img alt=\"検索結果の絞り込みができます。\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></a></p>\r\n" +
				"              \r\n" +
				"\r\n" +
				"  <h3 class=\"sublabel\">データベース</h3>\r\n" +
				"  <ul class=\"sub-ul\">\r\n" +
				"\r\n" +
				"    <li>    <div style=\" margin-left: 0em; \">\r\n" +
				"      <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=0_R100000001&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">        公共図書館蔵書</a>      (2544件)\r\n" +
				"    </div>\r\n" +
				"</li>\r\n" +
				"    <li>    <div style=\" margin-left: 0em; \">\r\n" +
				"      <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=0_R100000002&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">        国立国会図書館オンライン</a>      (1930件)\r\n" +
				"    </div>\r\n" +
				"</li>\r\n" +
				"    <li>    <div style=\" margin-left: 0em; \">\r\n" +
				"      <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=0_R100000004&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">        児童書総合目録</a>      (108件)\r\n" +
				"    </div>\r\n" +
				"</li>  </ul>\r\n" +
				"\r\n" +
				"\r\n" +
				"            </div>\r\n" +
				"            <div id=\"facet_group_library_sm\" class=\"subgroup\">\r\n" +
				"                <h3 class=\"sublabel\">所蔵館</h3>\r\n" +
				"  <ul class=\"sub-ul\">\r\n" +
				"  <li>  <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=3_%E5%9B%BD%E7%AB%8B%E5%9B%BD%E4%BC%9A%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">国立国会図書館</a>  (1930件)\r\n" +
				"</li>  <li>  <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=3_%E5%A0%BA%E5%B8%82%E7%AB%8B%E4%B8%AD%E5%A4%AE%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">堺市立中央図書館</a>  (1364件)\r\n" +
				"</li>  <li>  <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%BA%9C%E7%AB%8B%E4%B8%AD%E5%A4%AE%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">大阪府立中央図書館</a>  (1283件)\r\n" +
				"</li>  <li>  <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=3_%E5%B2%A1%E5%B1%B1%E7%9C%8C%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">岡山県立図書館</a>  (1269件)\r\n" +
				"</li>  </ul>\r\n" +
				"    <div class=\"show-wrapper\">\r\n" +
				"<script type=\"text/javascript\" language=\"javascript\">\r\n" +
				"//<![CDATA[\r\n" +
				"      function call_facet_ajax_urlfacet_group_library_sm(){\r\n" +
				"      wait_html = '<div style=\"margin:10px;\">\\\r\n" +
				"                      <img alt=\"Ajax-loader\" src=\"/images/ndl/ajax-loader.gif?1515070139\" />\\\r\n" +
				"                      <span style=\"font-weight:bold;\">所蔵館を取得中..</span>\\\r\n" +
				"                   </div>';\r\n" +
				"      document.getElementById('facet_group_library_sm').innerHTML = wait_html;\r\n" +
				"        $('#facet_group_library_sm').load('https://iss.ndl.go.jp/books/get_facet_group_library?ar=4e1f&filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&except_repository_nos[]=R100000038&except_repository_nos[]=R100000049&except_repository_nos[]=R100000073&do_remote_search=true&sort=df&ndc=699&display=thumbnail&search_mode=advanced')\r\n" +
				"      }\r\n" +
				"//]]>\r\n" +
				"</script>\r\n" +
				"        <span class=\"showall\"><a href=\"#\" onclick=\"call_facet_ajax_urlfacet_group_library_sm();\">▼全て表示</a></span>\r\n" +
				"    </div>\r\n" +
				"\r\n" +
				"            </div>\r\n" +
				"            <div id=\"facet_group_year_of_publication_sm\" class=\"subgroup\">\r\n" +
				"                <h3 class=\"sublabel\">出版年</h3>\r\n" +
				"  <ul class=\"sub-ul\">\r\n" +
				"  <li>  <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=4_2019&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">2019</a>  (46件)\r\n" +
				"</li>  <li>  <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=4_2018&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">2018</a>  (53件)\r\n" +
				"</li>  <li>  <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=4_2017&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">2017</a>  (41件)\r\n" +
				"</li>  <li>  <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=4_2016&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">2016</a>  (62件)\r\n" +
				"</li>  </ul>\r\n" +
				"    <div class=\"show-wrapper\">\r\n" +
				"<script type=\"text/javascript\" language=\"javascript\">\r\n" +
				"//<![CDATA[\r\n" +
				"      function call_facet_ajax_urlfacet_group_year_of_publication_sm(){\r\n" +
				"      wait_html = '<div style=\"margin:10px;\">\\\r\n" +
				"                      <img alt=\"Ajax-loader\" src=\"/images/ndl/ajax-loader.gif?1515070139\" />\\\r\n" +
				"                      <span style=\"font-weight:bold;\">出版年を取得中..</span>\\\r\n" +
				"                   </div>';\r\n" +
				"      document.getElementById('facet_group_year_of_publication_sm').innerHTML = wait_html;\r\n" +
				"        $('#facet_group_year_of_publication_sm').load('https://iss.ndl.go.jp/books/get_facet_year?ar=4e1f&filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&except_repository_nos[]=R100000038&except_repository_nos[]=R100000049&except_repository_nos[]=R100000073&do_remote_search=true&sort=df&ndc=699&display=thumbnail&search_mode=advanced')\r\n" +
				"      }\r\n" +
				"//]]>\r\n" +
				"</script>\r\n" +
				"        <span class=\"showall\"><a href=\"#\" onclick=\"call_facet_ajax_urlfacet_group_year_of_publication_sm();\">▼全て表示</a></span>\r\n" +
				"    </div>\r\n" +
				"\r\n" +
				"            </div>\r\n" +
				"            <div id=\"facet_group_ndc_facet_sm\" class=\"subgroup\">\r\n" +
				"                <h3 class=\"sublabel\">分類</h3>\r\n" +
				"  <ul class=\"sub-ul\">\r\n" +
				"  <li>  <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=5_1&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">1.哲学</a>  (10件)\r\n" +
				"</li>  <li>  <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=5_3&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">3.社会科学</a>  (6件)\r\n" +
				"</li>  <li>  <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=5_4&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">4.自然科学</a>  (10件)\r\n" +
				"</li>  <li>  <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=5_5&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">5.技術</a>  (3件)\r\n" +
				"</li>  <li>  <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=5_6&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">6.産業</a>  (2544件)\r\n" +
				"</li>  <li>  <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=5_7&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">7.芸術</a>  (2件)\r\n" +
				"</li>  <li>  <a href=\"/books?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;filters[]=5_8&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\">8.言語</a>  (1件)\r\n" +
				"</li>  </ul>\r\n" +
				"\r\n" +
				"            </div>\r\n" +
				"\r\n" +
				"\r\n" +
				"                <div id=\"clustering_word_group\" class=\"subgroup\">\r\n" +
				"          <h3 class=\"sublabel\">特徴語（実証実験）</h3>\r\n" +
				"          <ul class=\"sub-ul\">\r\n" +
				"            <li>              <a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced&amp;cfilter[]=%E3%83%9B%E3%82%A6%E3%82%BD%E3%82%A6\">ホウソウ</a>\r\n" +
				"</li>            <li>              <a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced&amp;cfilter[]=%E3%83%9B%E3%82%A6%E3%82%BD%E3%82%A6+%E3%83%90%E3%83%B3%E3%82%B0%E3%83%9F\">ホウソウ バングミ</a>\r\n" +
				"</li>            <li>              <a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced&amp;cfilter[]=%E3%83%9B%E3%82%A6%E3%82%BD%E3%82%A6+%E3%82%B8%E3%82%AE%E3%83%A7%E3%82%A6\">ホウソウ ジギョウ</a>\r\n" +
				"</li>            <li>              <a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced&amp;cfilter[]=%E3%83%8B%E3%83%83%E3%83%9D%E3%83%B3+%E3%83%9B%E3%82%A6%E3%82%BD%E3%82%A6+%E3%82%AD%E3%83%A7%E3%82%A6%E3%82%AB%E3%82%A4\">ニッポン ホウソウ キョウカイ</a>\r\n" +
				"</li>            <li class=\"additional\">              <a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced&amp;cfilter[]=%E6%94%BE%E9%80%81%E4%BA%8B%E6%A5%AD+%E6%97%A5%E6%9C%AC\">放送事業 日本</a>\r\n" +
				"</li>            <li class=\"additional\">              <a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced&amp;cfilter[]=%E3%83%86%E3%83%AC%E3%83%93+%E3%83%9B%E3%82%A6%E3%82%BD%E3%82%A6\">テレビ ホウソウ</a>\r\n" +
				"</li>            <li class=\"additional\">              <a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced&amp;cfilter[]=%E3%83%86%E3%83%AC%E3%83%93%E3%83%BB%E3%83%A9%E3%82%B8%E3%82%AA%E7%95%AA%E7%B5%84%E5%80%8B%E4%BA%BA%E8%A6%96%E8%81%B4%E7%8E%87%E8%AA%BF%E6%9F%BB%E5%85%A8%E5%9B%BD%E7%B5%90%E6%9E%9C%E8%A1%A8\">テレビ・ラジオ番組個人視聴率調査全国結果表</a>\r\n" +
				"</li>            <li class=\"additional\">              <a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced&amp;cfilter[]=%E6%94%BE%E9%80%81%E4%BA%8B%E6%A5%AD+%E5%B9%B4%E9%91%91\">放送事業 年鑑</a>\r\n" +
				"</li>            <li class=\"additional\">              <a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced&amp;cfilter[]=%E3%81%8A%E3%82%82%E3%81%84%E3%83%83%E3%81%8D%E3%82%8A%E3%83%86%E3%83%AC%E3%83%93\">おもいッきりテレビ</a>\r\n" +
				"</li>            <li class=\"additional\">              <a href=\"https://iss.ndl.go.jp/books?ar=4e1f&amp;filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;ndc=699&amp;display=thumbnail&amp;search_mode=advanced&amp;cfilter[]=%E6%94%BE%E9%80%81%E5%8F%97%E4%BF%A1%E5%A5%91%E7%B4%84%E6%95%B0%E7%B5%B1%E8%A8%88%E8%A6%81%E8%A6%A7\">放送受信契約数統計要覧</a>\r\n" +
				"</li>          </ul>\r\n" +
				"            <div class=\"show-wrapper\">\r\n" +
				"              <span class=\"showall\"><a href=\"#\">▼全て表示</a></span><span class=\"showsome\"><a href=\"#\">▲一部を表示</a></span>\r\n" +
				"            </div>\r\n" +
				"        </div>\r\n" +
				"      \r\n" +
				"      </div><!-- end of div.facet-wrapper-->\r\n" +
				"      <p class=\"guidance\"><img alt=\"検索結果の絞り込み　ここまで\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></p>\r\n" +
				"    </div><!-- end of div#facet -->\r\n" +
				"  </div><!-- end of div#resultlist_left-wrapper -->\r\n" +
				"\r\n" +
				"  <div id=\"keyword\">\r\n" +
				"      <div class=\"keyword-wrapper\">\r\n" +
				"        <div id=\"subject_authority_keywords\">\r\n" +
				"  <script type=\"text/javascript\">\r\n" +
				"//<![CDATA[\r\n" +
				"$('#subject_authority_keywords').load('https://iss.ndl.go.jp/books/get_subject_authority_keywords?ar=4e1f&filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&except_repository_nos[]=R100000038&except_repository_nos[]=R100000049&except_repository_nos[]=R100000073&do_remote_search=true&sort=df&ndc=699&display=thumbnail&search_mode=advanced')\r\n" +
				"//]]>\r\n" +
				"</script>\r\n" +
				"</div>\r\n" +
				"<div id=\"author_authority_keywords\">\r\n" +
				"    <h2 class=\"mainlabel\">\r\n" +
				"    著者名キーワード\r\n" +
				"  </h2>\r\n" +
				"  <div class=\"subgroup\">\r\n" +
				"  <ul class=\"sub-ul\">\r\n" +
				"        <li>\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E6%97%A5%E6%9C%AC%E6%94%BE%E9%80%81%E5%8D%94%E4%BC%9A&amp;do_remote_search=true\">日本放送協会</a><br />\r\n" +
				"</li>        <li>\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E5%BF%97%E8%B3%80%E4%BF%A1%E5%A4%AB&amp;do_remote_search=true\">志賀信夫</a><br />\r\n" +
				"</li>        <li>\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E3%83%95%E3%82%B8%E3%83%86%E3%83%AC%E3%83%93%E3%82%B8%E3%83%A7%E3%83%B3&amp;do_remote_search=true\">フジテレビジョン</a><br />\r\n" +
				"</li>        <li>\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E8%A5%BF%E6%AD%A3&amp;do_remote_search=true\">西正</a><br />\r\n" +
				"</li>        <li>\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E6%97%A5%E6%9C%AC%E6%B0%91%E9%96%93%E6%94%BE%E9%80%81%E9%80%A3%E7%9B%9F&amp;do_remote_search=true\">日本民間放送連盟</a><br />\r\n" +
				"</li>        <li>\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E3%83%8A%E3%83%B3%E3%82%B7%E3%83%BC%E9%96%A2&amp;do_remote_search=true\">ナンシー関</a><br />\r\n" +
				"</li>        <li>\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E6%97%A5%E6%9C%AC%E3%83%86%E3%83%AC%E3%83%93%E6%94%BE%E9%80%81%E7%B6%B2%E6%A0%AA%E5%BC%8F%E4%BC%9A%E7%A4%BE&amp;do_remote_search=true\">日本テレビ放送網株式会社</a><br />\r\n" +
				"</li>        <li class=\"additional\">\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E6%9D%B1%E4%BA%AC%E6%94%BE%E9%80%81&amp;do_remote_search=true\">東京放送</a><br />\r\n" +
				"</li>        <li class=\"additional\">\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E3%83%86%E3%83%AC%E3%83%93%E6%9D%B1%E4%BA%AC&amp;do_remote_search=true\">テレビ東京</a><br />\r\n" +
				"</li>        <li class=\"additional\">\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E6%AF%8E%E6%97%A5%E6%94%BE%E9%80%81&amp;do_remote_search=true\">毎日放送</a><br />\r\n" +
				"</li>        <li class=\"additional\">\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E5%B0%8F%E7%94%B0%E6%A1%90%E8%AA%A0&amp;do_remote_search=true\">小田桐誠</a><br />\r\n" +
				"</li>        <li class=\"additional\">\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E7%AB%B9%E5%86%85%E7%BE%A9%E5%92%8C&amp;do_remote_search=true\">竹内義和</a><br />\r\n" +
				"</li>        <li class=\"additional\">\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E8%AA%AD%E5%A3%B2%E3%83%86%E3%83%AC%E3%83%93%E6%94%BE%E9%80%81%E6%A0%AA%E5%BC%8F%E4%BC%9A%E7%A4%BE&amp;do_remote_search=true\">読売テレビ放送株式会社</a><br />\r\n" +
				"</li>        <li class=\"additional\">\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E3%83%8B%E3%83%83%E3%83%9D%E3%83%B3%E6%94%BE%E9%80%81&amp;do_remote_search=true\">ニッポン放送</a><br />\r\n" +
				"</li>        <li class=\"additional\">\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E7%94%B0%E5%8E%9F%E7%B7%8F%E4%B8%80%E6%9C%97&amp;do_remote_search=true\">田原総一朗</a><br />\r\n" +
				"</li>        <li class=\"additional\">\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E5%B3%B6%E9%87%8E%E5%8A%9F%E7%B7%92&amp;do_remote_search=true\">島野功緒</a><br />\r\n" +
				"</li>        <li class=\"additional\">\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E5%BA%83%E7%80%AC%E4%B9%85%E7%BE%8E%E5%AD%90&amp;do_remote_search=true\">広瀬久美子</a><br />\r\n" +
				"</li>        <li class=\"additional\">\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E3%83%A1%E3%83%87%E3%82%A3%E3%82%A2%E7%B7%8F%E5%90%88%E7%A0%94%E7%A9%B6%E6%89%80&amp;do_remote_search=true\">メディア総合研究所</a><br />\r\n" +
				"</li>        <li class=\"additional\">\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E5%A4%AA%E7%94%B0%E7%9C%81%E4%B8%80&amp;do_remote_search=true\">太田省一</a><br />\r\n" +
				"</li>        <li class=\"additional\">\r\n" +
				"          <a href=\"https://iss.ndl.go.jp/books?any=%E5%B1%B1%E6%A0%B9%E5%9F%BA%E4%B8%96&amp;do_remote_search=true\">山根基世</a><br />\r\n" +
				"</li>  </ul>\r\n" +
				"  <div class=\"show-wrapper\">\r\n" +
				"    <span class=\"showall\"><a href=\"#\">▼全て表示</a></span><span class=\"showsome\"><a href=\"#\">▲一部を表示</a></span>\r\n" +
				"  </div>\r\n" +
				"  </div>\r\n" +
				"</div>\r\n" +
				"<div id=\"jglobal_keywords\">\r\n" +
				"  \r\n" +
				"<div id=\"jglobal_contents\">\r\n" +
				"</div>\r\n" +
				"<div>\r\n" +
				"<script type=\"text/javascript\">\r\n" +
				"//<![CDATA[\r\n" +
				"var search_keywords = '';\r\n" +
				"//]]>\r\n" +
				"</script>\r\n" +
				"</div>\r\n" +
				"</div>\r\n" +
				"<p class=\"guidance\"><img alt=\"関連キーワードで検索　ここまで\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></p>\r\n" +
				"\r\n" +
				"          <div class=\"other-service\">\r\n" +
				"    <h2 class=\"mainlabel\">外部サービスで検索</h2>\r\n" +
				"    <div class=\"subgroup\">\r\n" +
				"      <h3 class=\"sublabel\">書籍検索</h3>\r\n" +
				"      <ul class=\"sub-ul\">\r\n" +
				"        <li><img alt=\"新しいウインドウが開きます\" class=\"guidance \" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /><a href=\"http://www.google.co.jp/search?tbs=bks:1&amp;tbo=p&amp;q=\" target=\"_blank\">Google Book</a></li>\r\n" +
				"        <li><img alt=\"新しいウインドウが開きます\" class=\"guidance \" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /><a href=\"http://scholar.google.co.jp/scholar?q= \" target=\"_blank\">Google Scholar</a></li>\r\n" +
				"        <li><img alt=\"新しいウインドウが開きます\" class=\"guidance \" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /><a href=\"http://webcatplus.nii.ac.jp/index.html?type=equals-book&amp;text=\" target=\"_blank\">WebCat Plus</a></li>\r\n" +
				"        <li><img alt=\"新しいウインドウが開きます\" class=\"guidance \" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /><a href=\"http://www.worldcat.org/search?q=\" target=\"_blank\">World Cat</a></li>\r\n" +
				"        <!-- li><img alt=\"新しいウインドウが開きます\" class=\"guidance \" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /><a href=\"http://202.231.40.111/GlobalFinder/cgi/Start.exe\" target=\"_blank\">人間文化研究機構</a></li -->\r\n" +
				"      </ul>\r\n" +
				"    </div>\r\n" +
				"    <div class=\"subgroup\">\r\n" +
				"      <h3 class=\"sublabel\">調べ方</h3>\r\n" +
				"      <ul class=\"sub-ul\">\r\n" +
				"        <li><img alt=\"新しいウインドウが開きます\" class=\"guidance \" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /><a href=\"http://rnavi.ndl.go.jp/ln-search/#\" target=\"_blank\">リサーチナビ</a></li>\r\n" +
				"      </ul>\r\n" +
				"    </div>\r\n" +
				"    <div class=\"subgroup\">\r\n" +
				"      <h3 class=\"sublabel\">辞書</h3>\r\n" +
				"      <ul class=\"sub-ul\">\r\n" +
				"        <li><img alt=\"新しいウインドウが開きます\" class=\"guidance \" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /><a href=\"http://ja.wikipedia.org/w/index.php?title=特別%3A検索&amp;search=\" target=\"_blank\">Wikipedia</a></li>\r\n" +
				"      </ul>\r\n" +
				"    </div>\r\n" +
				"    <div class=\"subgroup\">\r\n" +
				"      <h3 class=\"sublabel\">検索エンジン</h3>\r\n" +
				"      <ul class=\"sub-ul\">\r\n" +
				"        <li><img alt=\"新しいウインドウが開きます\" class=\"guidance \" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /><a href=\"http://www.google.co.jp/search?ie=utf-8&amp;oe=utf-8&amp;q=\" target=\"_blank\">google.co.jp</a></li>\r\n" +
				"        <li><img alt=\"新しいウインドウが開きます\" class=\"guidance \" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /><a href=\"http://search.yahoo.co.jp/search?ei=UTF-8&amp;p=\" target=\"_blank\">yahoo.co.jp</a></li>\r\n" +
				"        <li><img alt=\"新しいウインドウが開きます\" class=\"guidance \" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /><a href=\"http://search.goo.ne.jp/web.jsp?MT=\" target=\"_blank\">goo.ne.jp</a></li>\r\n" +
				"      </ul>\r\n" +
				"    </div>\r\n" +
				"    <p class=\"guidance\"><img alt=\"外部サービスで検索　ここまで\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></p>\r\n" +
				"  </div><!-- end of div#other_service -->\r\n" +
				"<script type=\"text/javascript\">\r\n" +
				"//<![CDATA[\r\n" +
				"    $(function(){\r\n" +
				"    var $ext_service = $('#external_service_subgroup')\r\n" +
				"    setShowAllSwitch($('.showall', $ext_service), $('.showsome', $ext_service), $('.additional', $ext_service));\r\n" +
				"    })\r\n" +
				"\r\n" +
				"//]]>\r\n" +
				"</script>\r\n" +
				"      </div><!-- end of div#keyword-wrapper -->\r\n" +
				"      <div class=\"bibliography-info\"><a name=\"bibliography-info\" id=\"bibliography-info\"></a>\r\n" +
				"  <h2 class=\"mainlabel\">検索結果を出力</h2>\r\n" +
				"  <div class=\"subgroup\" >\r\n" +
				"    <ul class=\"sub-ul\">\r\n" +
				"        <li>\r\n" +
				"          <img alt=\"新しいウインドウが開きます\" class=\"guidance\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" />\r\n" +
				"          <a href=\"/books.rss?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;display=thumbnail&amp;ndc=699&amp;search_mode=advanced\" class=\"rss\" target=\"_blank\">検索結果のRSS</a>\r\n" +
				"          <p>この検索キーワードに関する新着図書の情報をRSSで受け取ることができます。</p>\r\n" +
				"        </li>\r\n" +
				"    </ul>\r\n" +
				"  </div>\r\n" +
				"  <div class=\"subgroup\" >\r\n" +
				"    <ul class=\"sub-ul\">\r\n" +
				"      <li><img alt=\"新しいウインドウが開きます\" class=\"guidance \" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" />\r\n" +
				"        <a href=\"/books.refworks?filters[]=3_%E5%A4%A7%E9%98%AA%E5%B8%82%E7%AB%8B%E5%9B%B3%E6%9B%B8%E9%A4%A8&amp;ar=4e1f&amp;except_repository_nos[]=R100000038&amp;except_repository_nos[]=R100000049&amp;except_repository_nos[]=R100000073&amp;do_remote_search=true&amp;page=1&amp;display=thumbnail&amp;ndc=699&amp;sort=df&amp;search_mode=advanced\" class=\"refworks\" target=\"_blank\">RefWorks出力</a>\r\n" +
				"        <p>書誌情報を、オンラインデータベースからRefWorks上の個人フォルダに直接取り込むことができます。</p>\r\n" +
				"      </li>\r\n" +
				"      <li><img alt=\"新しいウインドウが開きます\" class=\"guidance \" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /><a class=\"external\" href=\"http://en.wikipedia.org/wiki/RefWorks\" target=\"_blank\">RefWorksとは</a></li>\r\n" +
				"    </ul>\r\n" +
				"  </div>\r\n" +
				"  <p class=\"guidance\"><img alt=\"検索結果を出力　ここまで\" class=\"guidance\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></p>\r\n" +
				"</div><!-- end of div#bibliography_info -->\r\n" +
				"\r\n" +
				"  </div><!-- end of div#keyword -->\r\n" +
				"</div><!-- end of div#resultlist -->\r\n" +
				"\r\n" +
				"\r\n" +
				"<div id=\"footer\" class=\"footer\">\r\n" +
				"<p class=\"guidance\"><img alt=\"以下、フッターです\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></p>\r\n" +
				"<ul>\r\n" +
				"<li id=\"home\"><a href=\"http://www.ndl.go.jp/\">国立国会図書館ホーム</a></li>\r\n" +
				"<li><a href=\"https://ndlonline.ndl.go.jp/\">国立国会図書館オンライン</a></li>\r\n" +
				"<li><a href=\"/children/top\">国際子ども図書館 子どもOPAC</a></li>\r\n" +
				"<li><a href=\"http://id.ndl.go.jp/auth/ndla\" title=\"国立国会図書館典拠データ検索・提供サービス\">Web NDL Authorities</a></li>\r\n" +
				"\r\n" +
				"<li><a href=\"https://iss.ndl.go.jp/information/outline/\">国立国会図書館サーチについて</a></li>\r\n" +
				"<li><a href=\"https://www.ndl.go.jp/jp/service/contact/index.html\">お問い合わせ</a></li>\r\n" +
				"</ul>\r\n" +
				"<p class=\"guidance\"><a href=\"#header\">ページトップに戻る</a></p>\r\n" +
				"</div>\r\n" +
				"\r\n" +
				"<address>Copyright &copy; 2012 National Diet Library. All Rights Reserved.</address>\r\n" +
				"<p class=\"guidance\"><img alt=\"フッター　ここまで\" height=\"1\" src=\"/images/ndl/spacer.png?1515070139\" width=\"1\" /></p>\r\n" +
				"\r\n" +
				"\r\n" +
				"<script type=\"text/javascript\">\r\n" +
				"//<![CDATA[\r\n" +
				"  $(function(){\r\n" +
				"  if($.cookie(\"scroll_y\")){\r\n" +
				"    window.scrollBy(0, $.cookie(\"scroll_y\"));\r\n" +
				"    $.cookie(\"scroll_y\", \"\", { expires: -1 }); \r\n" +
				"  }\r\n" +
				"  })\r\n" +
				"//]]>\r\n" +
				"</script>\r\n" +
				"\r\n" +
				"</body>\r\n" +
				"</html>",true);
		System.out.println(p.parse());
		System.out.println(p.has100());
	}
*/
}
