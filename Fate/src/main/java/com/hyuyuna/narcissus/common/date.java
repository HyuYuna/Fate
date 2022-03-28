package com.hyuyuna.narcissus.common;

public class date {

	public static void main(String[] args) {
		
		String sql = "update gs_morgue set db_ins_tm = ";
		
		String date = "2021년04월01일10시56분58초";
		
		String datetime = "'" + date.substring(0,4) + "-" + date.substring(5,7) + "-" + date.substring(8,10) + " " + date.substring(11,13) + ":" + date.substring(14,16) + ":" + date.substring(17,19) + "'";
		
		String where = " where num =";
				
		System.out.print(sql+datetime+where);
	}

}
