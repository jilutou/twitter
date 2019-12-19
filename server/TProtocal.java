package server;

public interface TProtocal {
	int U_LOGIN = 1001;
	int U_REGISTER = 1002;
	int U_FOLLOW = 1003;
	int U_GETUSER = 1004;
	int U_GETFOLLOWING = 1005;
	int U_GETFOLLOWERS = 1006;
	int U_TWEET1 = 1007;
	int U_DELTWEET = 1008;
	int U_RETWEET = 1009;
	int U_LIKE = 1011;
	int U_MARK = 1012;
	int U_GETTWEET = 1013;
	int U_GETALLTWEETS = 1014;
	int U_GETALLLRTWEETS =1015;
	int U_GETUTWEETS = 1016;
	int U_GETURLTWEETS = 1017;
	int U_GETCOMMENT = 1018;
	int U_GETNOTI = 1019;
	int U_GETMESSAGES = 1020;
	int U_GETBOOKMARKS = 1021;
	int U_CREATEOWNEDLIST = 1022;
	
	int U_DELOWNEDLIST = 1023;
	int U_GETOWNED = 1024;
	int U_SUBSCRIBE = 1025;
	int U_GETSUBSCRIBED = 1026;
	int U_GETLISTMEMBERS = 1027;
	int U_GETLISTSUBSCRIBERS = 1028;
	int U_GETLISTRETWEETS = 1029;
	int U_GETMEMBER = 1030;
	int U_UPDOWNLIST = 1031;
	int U_ADDUSER = 1032;
	int U_DELUSER = 1033;
	int U_CREATEMOMENT = 1034;
	int U_GETMOMENTS = 1035;
	int U_GETMTWEETS = 1036;
	int U_UPDMOMENT = 1037;
	int U_DELMOMENT = 1038;
	int U_TWEET2 = 1039;
	int U_GETLISTTWEETS = 1040;
	
	
	int U_GETRECOMUSES=1041;
	int U_GETRECORD=1042;
	int U_ADDRECORD=1043;
	int U_DELMESSAGE=1044;
	int U_EDITPROFILE=1045;
	int U_SETPIC=1046;
	int U_SETBG=1047;
	int U_GETALLMOMENTS=1048;
	
	int U_SERCHTWEETS=1049;
	int U_GETFATHERTWEETS=1050;
	int U_GETRECOMMEND=1051;
	int U_GETNEWNOTI=1052;
	int U_SEARCHUSERS=1053;
	int U_READNOTI=1054;
	
	int A_DELUSER = 2001;
	int A_DELTWEET = 2002;
	
	int SENDPIC=3001;
	int GETPIC=3002;
	int GETTRENDS=3003;
	int GETFILE=3004;
	int SENDFILE=3005;
	
}