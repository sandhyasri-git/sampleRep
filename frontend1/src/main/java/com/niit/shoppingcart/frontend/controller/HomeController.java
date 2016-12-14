package com.niit.shoppingcart.frontend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.giftsgallery.dao.CategoryDAO;
import com.niit.shoppingcart.giftsgallery.dao.ProductDAO;
import com.niit.shoppingcart.giftsgallery.dao.SupplierDAO;
import com.niit.shoppingcart.giftsgallery.dao.UserDAO;
import com.niit.shoppingcart.giftsgallery.model.Category;
import com.niit.shoppingcart.giftsgallery.model.Product;
import com.niit.shoppingcart.giftsgallery.model.Supplier;
import com.niit.shoppingcart.giftsgallery.model.UserInfo;

@Controller
public class HomeController {

	/*@Autowired
	Product product;
	
	@Autowired
	Category category;*/
	/*@RequestMapping("/register")
	public ModelAndView register() {
		
		return new ModelAndView("register","user",new UserInfo()); // 21.11.2016 -->changes made here then error removed //
		}*/

	/*@RequestMapping("/signup")
	public ModelAndView signup() {
		System.out.println("here");
		return new ModelAndView("signup","us",new UserInfo()); // 21.11.2016 -->changes made here then error removed //
		}*/
	/*@RequestMapping("/signup")
	public ModelAndView show()
	{
		System.out.println("Before");
		return new ModelAndView("login");
	}
*/
	@Autowired
	Category category;
	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;
	@RequestMapping("/home")
	public String showhome() {
		return "home";
	}

	@RequestMapping("/AboutUs")
	public String showAboutUs() {
		return "AboutUs";
	}

	
	@RequestMapping("/")
	public String showIndex() {
		return "home";
	}

	@RequestMapping("/login")
	public String showlogin() {
		return "login";
	}

	@RequestMapping("/addProducts")
	public ModelAndView showaddProducts(Model model) {
		
		System.out.println("in product");
		ModelAndView mv = new ModelAndView("addProducts");
		model.addAttribute("productlist", productDAO.list());
		model.addAttribute("category", category);
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", this.supplierDAO.list());
		System.out.println("In Products Page");
		return mv;


	}

	@RequestMapping("/Productdetails")
	public ModelAndView productViewDetails(@RequestParam("id") String id, Model model) {
		System.out.println("I am in productViewDetails");
		System.out.println("ID:" + id);
		int i = Integer.parseInt(id);
		model.addAttribute("productList", this.productDAO.list());
		Product product = productDAO.get(i);
		return new ModelAndView("Productdetails", "product", product);
	}
	
	

	/* Logout 
	@RequestMapping("/Logout")
	public String showLogout() {
		return "Logout";

	}*/

//===================================Product Operations ==========================================	
	/* Add Product */
	
	@Autowired
	ProductDAO productDAO;

	@ModelAttribute
	public Product returnObject()

	{
		return new Product();
	}

	@RequestMapping("/Products")
	public String showProducts() {
		return "Products";
		}

	@RequestMapping("/AdminProducts")
	public ModelAndView showAProducts(Model model) {
		ModelAndView mv= new ModelAndView("AdminProducts");
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("supplierList",supplierDAO.list());
		return mv;
		}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String ShowAddProduct(@ModelAttribute("product")Product product,
			Model model, BindingResult result, HttpServletRequest request) throws IOException {
		System.out.println(product.getProd_name());
		System.out.println("image upload");
		System.out.println("myproduct controller called");
		MultipartFile image = product.getImage();
		Path path;/* belong to nio package */
		path = Paths.get(
				"E:/DT8/Bhumika/frontend1/src/main/webapp/resources/images/" + product.getProd_name() + ".jpg");
		System.out.println("Path=" + path);
		System.out.println("File name" + product.getImage().getOriginalFilename());
		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
				System.out.println("Image Saved in:" + path.toString());
			} catch (Exception e)

			{
				e.printStackTrace();
				System.out.println("Image not saved");

			}
		}
		/*product.setCat_Id(1);
		product.setSupp_Id(1);
		Supplier sup=new Supplier();
		product.setSupplier(sup);
		Category cat= new Category();
		product.setCategory(cat);*/
		/*Supplier supplier = supplierDAO.get(product.getSupplier().getSup_id());
		supplierDAO.saveOrUpdate(supplier);

		 Category category = categoryDAO.get(product.getCategory().getCat_id());
		categoryDAO.saveOrUpdate(category);*/
		Category category = categoryDAO.getByName(product.getCategory().getCatname());
		categoryDAO.saveOrUpdate(category);  // why to save??

		Supplier supplier = supplierDAO.getByName(product.getSupplier().getSup_name());
		supplierDAO.saveOrUpdate(supplier); // Why to save??
		
		
		
		product.setCategory(category);
		product.setSupplier(supplier);
		
		product.setCat_Id(category.getCat_id());
		product.setSupp_Id(supplier.getSup_id());
		productDAO.saveOrUpdate(product);



		// product.setSupplier((Set<Supplier>) supplier);
		System.out.println("set");
		
		
		model.addAttribute("message", "Product added successully");
		model.addAttribute("productList", productDAO.list());
		return "Products";

	}
	@RequestMapping(value = "/DeleteProduct")
	public ModelAndView Deleteproduct(@RequestParam("id") String id) throws Exception {
		System.out.println("deleting prod");
		int i=Integer.parseInt(id);
		Product product = productDAO.get(i);
		ModelAndView mv = new ModelAndView("AdminProducts");
		productDAO.delete(product);
		mv.addObject("AdminProducts", 0);
		
		return mv;
	}

	
	@RequestMapping(value = "pupdate{id}", method = RequestMethod.GET)
	public String updateSupplier(@PathVariable("id") String id, Model model) {
		ModelAndView mv = new ModelAndView("product");
		int i=Integer.parseInt(id);
		System.out.println("update product");
		model.addAttribute("product", this.productDAO.get(i));
		model.addAttribute("listProducts", this.productDAO.list());
		mv.addObject("productList", productDAO.list());

		return "product";

	}

	/*--------------- Add categories -------------------------------- */
	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping("/addCategories") // JSP page
	public ModelAndView showCategory(@ModelAttribute("category") Category category, BindingResult result,
			HttpServletRequest request,Model model)// commandname
	{
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", "this.categoryDAO.list()");
		ModelAndView mv = new ModelAndView("addCategories");
		return mv;
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category,Model model) {
		
		ModelAndView mv = new ModelAndView("Category");
			categoryDAO.saveOrUpdate(category);
			
		model.addAttribute("categoryList", categoryDAO.list());
		return "Category";
	}
	
	String setName;
	List<Product> plist;

	@SuppressWarnings("unchecked")
	@RequestMapping("/GsonCon")
	public @ResponseBody String getValues() throws Exception {
		String result = "";
		plist = productDAO.list();
		Gson gson = new Gson();
		result = gson.toJson(plist);
		return result;

	}

	@RequestMapping("/Category/addCategories") // JSP page
	public ModelAndView addCategory(@ModelAttribute("category") Category category, BindingResult result,
			HttpServletRequest request,Model model)// commandname
	{
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", "this.categoryDAO.list()");
		ModelAndView mv = new ModelAndView("addCategories");
		return mv;
	}

	@RequestMapping("edit")
	 public ModelAndView editUser(@RequestParam int id,
	   @ModelAttribute Category category) {
	  Category catObj = categoryDAO.get(id);
	  return new ModelAndView("edit", "categoryObject", catObj);
	 }

	 @RequestMapping("update")
	 public ModelAndView updateUser(@ModelAttribute Category category) {
	  //dataService.updateRow(employee);
		 categoryDAO.saveOrUpdate(category);
	  return new ModelAndView("redirect:addCategories");
	 }

//==================================User Operations===========================================
	
	// when user clicks submit these details are posted//
		@Autowired
		UserDAO userDAO;
		@Autowired
		UserInfo user;
		@RequestMapping(value = "/addUser", method = RequestMethod.POST)
		
		public String addUser(@ModelAttribute("us") UserInfo user, ModelMap model, BindingResult result,HttpServletRequest request) {
			System.out.println("In add user");
			
			model.addAttribute("id", user.getId());//no changes occur as of in strings//
			model.addAttribute("name", user.getName());
			model.addAttribute("phno", user.getPhno());
			model.addAttribute("emailid", user.getEmailid());
			model.addAttribute("address", user.getAddress());
			model.addAttribute("password", user.getPassword());
			user.setEnabled("true");
			user.setRole("ROLE_USER");
			userDAO.saveOrUpdate(user);
			return "login";
		}

		@RequestMapping("/validate")
		public ModelAndView checkUser(@RequestParam("username") String s1, @RequestParam("password") String s2,HttpSession ses) {
			String message;
			ModelAndView mv;
		
			if (s1.equals("s002@gmail.com") && s2.equals("s002")) {
				message = "valid";
				mv = new ModelAndView("AdminHome");
				mv.addObject("info", message);
				ses.setAttribute("loggedInUser", user.getName());
				ses.setAttribute("loggedInUserID", user.getId());
				ses.setAttribute("LoggedIn", "true");


			} else {
				message = "Invalid";
				mv = new ModelAndView("login");
				mv.addObject("info", message);
			}
			return mv;
		}
	
		@RequestMapping(value="/login_session_attributes")
		public String login_session_attributes(HttpSession session, Model model,@RequestParam(value="username")String id) {
			String name=SecurityContextHolder.getContext().getAuthentication().getName();
			UserInfo user=new UserInfo();
			System.out.println("inside security check");
			
			session.setAttribute("name", name);
			System.out.println(name);
			
			//user=userDAO.get(name);
			session.setAttribute("loggedInUser", user.getName());
	    	session.setAttribute("loggedInUserID", user.getId());
	    	
			session.setAttribute("LoggedIn", "true");
			
			@SuppressWarnings("unchecked")
			Collection<GrantedAuthority> authorities =(Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			
			String role="ROLE_USER";
			for(GrantedAuthority authority : authorities)
			{
				if(authority.getAuthority().equals(role))
				{
					System.out.println(role);
					return "home";
				}
				else
				{
					session.setAttribute("isAdmin", "true");
				}
				}
			return "AdminHome" ;
			
			
		}
		
		@RequestMapping("/perform_logout")
		public ModelAndView logout(HttpServletRequest request,HttpSession session){
			ModelAndView mv=new ModelAndView("home");
			Category category=new Category();
			session.invalidate();
			session=request.getSession(true);
			session.setAttribute("category", category);
			session.setAttribute("categoryList", categoryDAO.list());
			
			mv.addObject("logOutMessage", "You have successfully logged out!");
			mv.addObject("loggedout","true");
			
			return mv;
	}
		//================================Supplier=====================================
		
}
