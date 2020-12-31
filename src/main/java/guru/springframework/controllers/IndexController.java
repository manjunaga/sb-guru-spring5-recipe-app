package guru.springframework.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;

@Controller
public class IndexController {

	private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;

	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitofmeasurerepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitofmeasurerepository;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage() {
		
		Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
		Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByUomdescription("Teaspoon");
		
		System.out.println("Cat Id is " + categoryOptional.get().getId());
		System.out.println("UOM Id is " + unitOfMeasureOptional.get().getId());
		
		return "index";
	}
}
