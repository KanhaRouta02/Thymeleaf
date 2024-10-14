package in.kanha.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.kanha.entity.Product;
import in.kanha.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/")
	public String lodingForm(Model model)
	{
		model.addAttribute("product", new Product());
		return "index";
	}
	
	@PostMapping("/save")
	public String saveProduct(@Validated @ModelAttribute("product")  Product p ,BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "index";
		}
		Product pr = productRepository.save(p);
		if(pr.getId() != null)
		{
			model.addAttribute("msg", "Product Saved...✅");
		}
		return "index";
	}
	
	@GetMapping("/products")
	public String getProducts(Model model)
	{
		model.addAttribute("products",productRepository.findAll() );
		return "allproduct";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Integer id , Model model)
	{
		productRepository.deleteById(id);
		model.addAttribute("msg", "Product Deleted..✅");
		model.addAttribute("products",productRepository.findAll() );
		return "allproduct";
	}
	@GetMapping("/edit")
	public String editProduct( @RequestParam("id") Integer id , Model model)
	{
		Optional<Product> byId = productRepository.findById(id);
		if(byId.isPresent()) {
			Product product = byId.get();
		    model.addAttribute("product", product);
		}
		return "index";
	}
}
