package com.letsstartcoding.springexample.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.letsstartcoding.springexample.dao.*;
import com.letsstartcoding.springexample.model.*;
import com.sun.tracing.dtrace.ModuleAttributes;

@Controller

public class TournamentController {
	
	 @Autowired
	private TournamentDAO tournamentDAO;
	 
	 @RequestMapping("/ViewTournament")  
   public ModelAndView viewstudents(){  
       List<TournamentModel> list=tournamentDAO.getTournamentDetails();
       return new ModelAndView("ViewTournament","list",list);  
   } 
	
	 @RequestMapping("/viewtourdetails/{tour_id}")  
	   public ModelAndView viewtourdetails(@PathVariable int tour_id){  
	       return new ModelAndView("ViewTourDetails","tour_id",tour_id);  
	   } 
		
	 @RequestMapping("/viewteams/{tour_id}")  
	   public ModelAndView viewteams(@PathVariable int tour_id){  
	       
		 List<TeamModel> list=tournamentDAO.getTeamList(tour_id);
		
		 
		 return new ModelAndView("ViewTeams","list",list);
	     
	   } 
	 @RequestMapping("/viewpoints/{tour_id}")  
	   public ModelAndView viewpoints(@PathVariable int tour_id){  
		 List<PointsModel> list=tournamentDAO.getTeamPoints(tour_id);
	       return new ModelAndView("ViewPoints","list",list);  
	   } 
	 @RequestMapping("/viewowner")  
	   public ModelAndView viewowner(){  
	       
		 List<OwnerModel> list=tournamentDAO.getOwners();
	       return new ModelAndView("ViewOwners","list",list);  
	   } 
	
	 @RequestMapping("/addtournament")  
	   public ModelAndView addtournament(){  
	       
		 List<TournamentModel> list=tournamentDAO.getTournamentDetails();
	       return new ModelAndView("ViewTournament","list",list);  
	   } 
	 @RequestMapping(value ="/addtournament",method = RequestMethod.GET)
		public String newRegistration(ModelMap model) {
			TournamentModel tournamentModel = new TournamentModel();
			model.addAttribute("tournament", tournamentModel);
			return "addtournament";
		}
	 
	 @RequestMapping(value="/deletetournament/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){  
	    	tournamentDAO.delete(id);  
	        return new ModelAndView("redirect:/ViewTournament");  
	    }
		
	 @RequestMapping(value ="/save",method = RequestMethod.POST)
		public String saveRegistration(@Valid @ModelAttribute("tournament") TournamentModel tournament,
				BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) {

			if (result.hasErrors()) {
				return "addtournament";//will redirect to viewemp request mapping  
			}
			
			tournamentDAO.save(tournament);		
			//redirectAttributes.addFlashAttribute("message", "Student " + student.getFirstName()+" "+student.getLastName() + " saved");
			return "redirect:/ViewTournament";//will redirect to viewemp request mapping 
		}

	 @RequestMapping(value ="/addNewTeam",method = RequestMethod.POST)
		public String saveTeam(@Valid @ModelAttribute("team") TeamModel team,
				BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) {

			if (result.hasErrors()) {
				return "addteam";//will redirect to viewemp request mapping  
			}
			
			int tour_id=tournamentDAO.addTeam(team);		
			//redirectAttributes.addFlashAttribute("message", "Student " + student.getFirstName()+" "+student.getLastName() + " saved");
			return "redirect:/viewteams/"+tour_id;//will redirect to viewemp request mapping 
		}

	@RequestMapping(value ="/addteams",method = RequestMethod.GET)
	public ModelAndView AddTeams(ModelMap model) {
		TeamModel team = new TeamModel();
		return new ModelAndView("addteam","team",team);
	}
	@ModelAttribute("TourList")
	public List<String> gettournamentNames() {
		return tournamentDAO.getTournamentNames();
	}

	@ModelAttribute("Owners")
	public List<String> getOwners() {
		return tournamentDAO.getOwnerNames();
	}

//	
//	@RequestMapping(value ="/save",method = RequestMethod.POST)
//	public String saveRegistration(@Valid Student student,
//			BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) {
//
//		if (result.hasErrors()) {
//			return "enroll";//will redirect to viewemp request mapping  
//		}
//		studentDao.save(student);		
//		//redirectAttributes.addFlashAttribute("message", "Student " + student.getFirstName()+" "+student.getLastName() + " saved");
//		return "redirect:/viewstudents/1";//will redirect to viewemp request mapping  
//	}
//	
//	@RequestMapping("/viewstudents")  
//    public ModelAndView viewstudents(){  
//        List<Student> list=studentDao.getAllStudents();
//        return new ModelAndView("viewstudents","list",list);  
//    } 
//	
//	/* It opens the student list for the given page id */
//	@RequestMapping(value="/viewstudents/{pageid}")  
//    public ModelAndView edit(@PathVariable int pageid){  
//        int total=2;  
//        if(pageid==1){}  
//        else{  
//            pageid=(pageid-1)*total+1;  
//        }  
//        List<Student> list=studentDao.getStudentsByPage(pageid,total);  
//          
//        return new ModelAndView("viewstudents","list",list);  
//    }
//	
//	/* It opens the record for the given id in editstudent page */
//	 @RequestMapping(value="/editstudent/{id}")  
//	    public String edit(@PathVariable int id,ModelMap model){  
//	       Student student=studentDao.getStudentById(id);  
//	       model.addAttribute("student", student);
//			return "editstudent";
//	        
//	        
//	    } 
//	 
//	 /* It updates record for the given id in editstudent page and redirects to /viewstudents */  
//	 @RequestMapping(value="/editsave",method = RequestMethod.POST)  
//	    public ModelAndView editsave(@ModelAttribute("student") Student emp){  
//	    	System.out.println("id is"+emp.getId());
//	    	studentDao.update(emp);  
//	        return new ModelAndView("redirect:/viewstudents/1");  
//	    }  
//	 
//	 /* It deletes record for the given id  and redirects to /viewstudents */  
//	    @RequestMapping(value="/deletestudent/{id}",method = RequestMethod.GET)  
//	    public ModelAndView delete(@PathVariable int id){  
//	    	studentDao.delete(id);  
//	        return new ModelAndView("redirect:/viewstudents/1");  
//	    }  
//	    
//	    /* It deletes record for the given id  and redirects to /viewstudents */  
//	    @RequestMapping(value="/delete",method = RequestMethod.GET)  
//	    public ModelAndView delete(){  
//	    	studentDao.delete();  
//	        return new ModelAndView("redirect:/enroll");  
//	    }  
//	
//	@ModelAttribute("sections")
//	public List<String> initializeSections() {
//
//		List<String> sections = new ArrayList<String>();
//		sections.add("Graduate");
//		sections.add("Post Graduate");
//		sections.add("Research");
//		return sections;
//	}
//
//	/*
//	 * Method used to populate the country list in view. Note that here you can
//	 * call external systems to provide real data.
//	 */
//	@ModelAttribute("countries")
//	public List<String> initializeCountries() {
//
//		List<String> countries = new ArrayList<String>();
//		countries.add("INDIA");
//		countries.add("USA");
//		countries.add("CANADA");
//		countries.add("FRANCE");
//		countries.add("GERMANY");
//		countries.add("ITALY");
//		countries.add("OTHER");
//		return countries;
//	}
//
//	/*
//	 * Method used to populate the subjects list in view. Note that here you can
//	 * call external systems to provide real data.
//	 */
//	@ModelAttribute("subjects")
//	public List<String> initializeSubjects() {
//
//		List<String> subjects = new ArrayList<String>();
//		subjects.add("Physics");
//		subjects.add("Chemistry");
//		subjects.add("Life Science");
//		subjects.add("Political Science");
//		subjects.add("Computer Science");
//		subjects.add("Mathmatics");
//		return subjects;
//	}
//	
//	/*
//	 * Method used to populate the Section list in view. Note that here you can
//	 * call external systems to provide real data.
//	 */
//	 @ModelAttribute("pageCount")
//		public List<String> initializePageCount() {
//		    int total=2;  
//			List<String> pageCount = new ArrayList<String>();
//			int count=studentDao.count(); 
//			int result=((count/total)+ (count%total));
//			for(int k=0;k<result;k++) {
//				pageCount.add(new Integer(k).toString());
//			}
//			
//			return pageCount;
//		}

}
