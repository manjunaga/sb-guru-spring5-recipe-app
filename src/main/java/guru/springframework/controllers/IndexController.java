package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.RecipeService;

@Controller
public class IndexController {

	private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;
	private final RecipeService recipeService;
	
//	public IndexController() {
//		super();
//		this.recipeService = null;
//	}
	
	public IndexController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}

//	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitofmeasurerepository, RecipeService recipeService) {
//		super();
//		this.categoryRepository = categoryRepository;
//		this.recipeService = recipeService;
//		this.unitOfMeasureRepository = unitofmeasurerepository;
//	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage(Model model) {
		
//		Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
//		Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByUomdescription("Teaspoon");
//		
//		System.out.println("Cat Id is " + categoryOptional.get().getId());
//		System.out.println("UOM Id is " + unitOfMeasureOptional.get().getId());
		
		model.addAttribute("recipes", recipeService.getRecipes());
		
		return "index";
	}
}
