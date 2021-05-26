CREATE TABLE `books` (
                         `bookID` int(10) NOT NULL AUTO_INCREMENT COMMENT '书id',
                         `bookName` varchar(100) NOT NULL COMMENT '书名',
                         `bookCounts` int(11) NOT NULL COMMENT '数量',
                         `detail` varchar(200) NOT NULL COMMENT '描述',
                         PRIMARY KEY (`bookID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8