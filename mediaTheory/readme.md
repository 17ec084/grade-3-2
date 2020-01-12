699.csv: 足立区図書館の蔵書で、699に分類された一般図書を検索した結果(検索日:2020/01/10 12:00～12:30)  
699_2.csv: 699.csvからメタデータを取り除いたもの。PostgreSQL移植用 (移植の際は **クライアント側** の文字コードに変換すること)  
authors.csv 699.csvをPostgreSQLに読み込み、各著者の冊数を集計したもの。  
publishers.csv 699.csvをPostgreSQLに読み込み、各出版者の冊数を集計したもの。  
authors_and_publishers.csv 699.csvをPostgreSQLに読み込み、著者と出版者の組ごとの冊数を集計したもの。
