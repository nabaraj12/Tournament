package com.letsstartcoding.springexample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


import com.letsstartcoding.springexample.model.*;


public class TournamentDAO  {
	
	
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	
	
	public void save(TournamentModel p) {
		
		String sqlCount = "select count(*) from TOURNAMENT";
		int totalCount=template.queryForObject(sqlCount, Integer.class);
		
		String sql="insert into TOURNAMENT(TOURNAMENT_ID,TOURNAMENT_NAME,PRIZE_MONEY) values('"+(totalCount+1)+"','"+p.getTOURNAMENT_NAME()+"','"+p.getPRIZE_MONEY()+"')";
		System.out.println(sql);
	     template.update(sql);  
	}
	
		
	public List<TournamentModel> getTournamentDetails() {
		
		
		return template.query("select * from tournament ORDER BY TOURNAMENT_ID",new ResultSetExtractor<List<TournamentModel>>(){  
		    
		     public List<TournamentModel> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<TournamentModel> list=new ArrayList<TournamentModel>();  
		        while(rs.next()){  
		        TournamentModel e=new TournamentModel();  
		        e.setTOURNAMENT_ID(rs.getInt(1));  
		        e.setTOURNAMENT_NAME(rs.getString(2));  
		        e.setPRIZE_MONEY(rs.getInt(3));  
		        
		        
		        list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
		  
		
		  }
	
public List<String> getTournamentNames() {
		
		
		return template.query("select TOURNAMENT_NAME from tournament",new ResultSetExtractor<List<String>>(){  
		    
		     public List<String> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<String> list=new ArrayList<String>();  
		        while(rs.next()){  
		        
		        	list.add(rs.getString(1));  
		        }  
		        return list;  
		        }  
		    });  
		  
		
		  }
	
	
public List<TeamModel> getTeamList(int tour_id) {
	
		String query_team="select * from TOURNY_TEAM_VW where TOURNAMENT_NAME=(select TOURNAMENT_NAME from TOURNAMENT where tournament_id="+tour_id+")";
		return template.query(query_team,new ResultSetExtractor<List<TeamModel>>(){  
		    
		     public List<TeamModel> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<TeamModel> list=new ArrayList<TeamModel>();  
		        while(rs.next()){  
		        TeamModel e=new TeamModel();  
		        e.setTEAM_NAME(rs.getString(1));
		        e.setOWNER(rs.getString(2));
		        e.setTOURNAMENT_NAME(rs.getString(3));
		        e.setTOURNAMENT_TEAM(rs.getString(4));
		        
		        list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
		  
		
		  }

public List<PointsModel> getTeamPoints(int tour_id) {
	
	String query_points="SELECT * FROM TOURNAMENT_RESULT_VW where TOURNAMENT_NAME=(select TOURNAMENT_NAME from TOURNAMENT where tournament_id="+tour_id+")";
	return template.query(query_points,new ResultSetExtractor<List<PointsModel>>(){  
	    
	     public List<PointsModel> extractData(ResultSet rs) throws SQLException,  
	            DataAccessException {  
	      
	        List<PointsModel> list=new ArrayList<PointsModel>();  
	        while(rs.next()){  
	        PointsModel e=new PointsModel();  
	        e.setTEAM_NAME(rs.getString(1));
	        e.setOWNER(rs.getString(2));
	        e.setTOURNAMENT_NAME(rs.getString(3));
	        e.setTOTAL_POINTS(rs.getString(4));
	        
	        list.add(e);  
	        }  
	        return list;  
	        }  
	    });  
	  
	
	  }
public List<OwnerModel> getOwners() {
	
	String query_owner="select * from teams";
	return template.query(query_owner,new ResultSetExtractor<List<OwnerModel>>(){  
	    
	     public List<OwnerModel> extractData(ResultSet rs) throws SQLException,  
	            DataAccessException {  
	      
	        List<OwnerModel> list=new ArrayList<OwnerModel>();  
	        while(rs.next()){  
	        OwnerModel e=new OwnerModel();  
	        e.setTEAM_ID(rs.getString(1));
	        e.setTEAM_NAME(rs.getString(2));
	        e.setOWNER(rs.getString(3));
	        e.setLOCATION(rs.getString(4));
	        
	        list.add(e);  
	        }  
	        return list;  
	        }  
	    });  
}
	  
	public List<String> getOwnerNames() {
		
		String query_owner="select owner from teams";
		return template.query(query_owner,new ResultSetExtractor<List<String>>(){  
		    
		     public List<String> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<String> list=new ArrayList<String>();  
		        while(rs.next()){  
		        
		        list.add(rs.getString(1));  
		        }  
		        return list;  
		        }  
		    });  
	
	  }
public void delete(int id) {
	// TODO Auto-generated method stub
	String sql="delete from tournament where TOURNAMENT_ID="+id+"";  
    template.update(sql);  
	
}


public int addTeam(TeamModel team) {
	
	String tourid = "select TOURNAMENT_ID from TOURNAMENT where TOURNAMENT_NAME='"+team.getTOURNAMENT_NAME()+"'";
	int tour_id=template.queryForObject(tourid, Integer.class);
	
	String teamid = "select TEAM_ID from TEAMS where OWNER='"+team.getOWNER()+"'";
	int team_id=template.queryForObject(teamid, Integer.class);
	
	String sql="insert into TOURNAMENT_COMPOSITION(TOURNAMENT_ID,TEAM_ID,TEAM) values('"+tour_id+"','"+team_id+"','"+team.getTOURNAMENT_TEAM()+"')";
	
	template.update(sql);
	
	return tour_id;
	// TODO Auto-generated method stub
	
}


public List<PointsModel> editTeamPoint(String owner, String tournamentName) {
	// TODO Auto-generated method stub
	String sql="update table  into TOURNAMENT_COMPOSITION(TOURNAMENT_ID,TEAM_ID,TEAM) values('"+tour_id+"','"+team_id+"','"+team.getTOURNAMENT_TEAM()+"')";
	
	template.update(sql);
	
	return null;
}


//	public List<Student> getStudentsByPage(int pageid, int total) {
//		// TODO Auto-generated method stub
//		 String sql="select * from Student limit "+(pageid-1)+","+total;  
//		 return template.query(sql,new ResultSetExtractor<List<Student>>(){  
//		    
//		     public List<Student> extractData(ResultSet rs) throws SQLException,  
//		            DataAccessException {  
//		      
//		        List<Student> list=new ArrayList<Student>();  
//		        
//		        while(rs.next()){  
//		        Student e=new Student();  
//		        e.setId(rs.getInt(1));  
//		        e.setFirstName(rs.getString(2));  
//		        e.setLastName(rs.getString(3));  
//		        e.setSex(rs.getString(4));
//		        e.setDob(rs.getDate(5));
//		        e.setEmail(rs.getString(6));
//		        e.setSection(rs.getString(7));  
//		        e.setCountry(rs.getString(8));  
//		        e.setFirstAttempt(rs.getBoolean(9));
//		        e.setSubjects(convertDelimitedStringToList(rs.getString(10)));
//		        
//		        list.add(e);  
//		        }  
//		        return list;  
//		        }  
//		    });  
//		  }
//	
//	public Student getStudentById(int id) {
//		// TODO Auto-generated method stub
//				 return template.query("select * from student where ID="+id,new ResultSetExtractor<Student>(){  
//					    
//				     public Student extractData(ResultSet rs) throws SQLException,  
//				            DataAccessException {  
//				      
//				    	 Student e=new Student();  
//				        while(rs.next()){  
//				       
//				        	e.setId(rs.getInt(1));  
//					        e.setFirstName(rs.getString(2));  
//					        e.setLastName(rs.getString(3));  
//					        e.setSex(rs.getString(4));
//					        e.setDob(rs.getDate(5));
//					        e.setEmail(rs.getString(6));
//					        e.setSection(rs.getString(7));  
//					        e.setCountry(rs.getString(8));  
//					        e.setFirstAttempt(rs.getBoolean(9));
//					        e.setSubjects(convertDelimitedStringToList(rs.getString(10)));     
//				        }  
//				        return e;  
//				        }  
//				    });  
//			}
//	
//	private static List<String> convertDelimitedStringToList(String delimitedString) {
//
//		List<String> result = new ArrayList<String>();
//
//		if (!StringUtils.isEmpty(delimitedString)) {
//			result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
//		}
//		return result;
//
//	}
//	
//	public String ConvertDate(Date date){
//		
//		
//		   
//		  
//		 String formatedDate ="";
//	    try {
//	    	DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
//			date = (Date)formatter.parse(date.toString());
//			 Calendar cal = Calendar.getInstance();
//			   
//			    cal.setTime(date);
//			    
//			    formatedDate=cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH) + 1)+"-"+cal.get(Calendar.DATE);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	   
//	    
//	    return formatedDate;
//
//	   
//	  }
//
//
//
//	public int count() {
//		String sql="select count(*) from Student";
//		int count = template.queryForObject(sql,Integer.class);
//		return count;
//		  }
//
//
//
//	public void update(Student p) {
//		String sql="update Student set firstName='"+p.getFirstName()+"',lastName='"+p.getLastName()+"',sex='"+p.getSex()+"',dob='"+ConvertDate(p.getDob())+"',email='"+p.getEmail()+"',section='"+p.getSection()+"' ,country='"+p.getCountry()+"', firstAttempt="+p.isFirstAttempt()+",subjects='"+convertListToDelimitedString(p.getSubjects())+"' where ID="+p.getId()+"";
//		System.out.println(sql);
//       template.update(sql);  
//	}
//
//
//
//	public void delete(int id) {
//		// TODO Auto-generated method stub
//		String sql="delete from Student where ID="+id+"";  
//	    template.update(sql);  
//		
//	}
//
//
//
//	public void delete() {
//		// TODO Auto-generated method stub
//		String sql="delete from Student where ID>0";  
//	    template.update(sql); 
//	}
//
//
//
	

	

}
