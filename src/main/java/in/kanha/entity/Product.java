package in.kanha.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank(message = "Name field is requird..")
	@Size(min=3 ,max=15,message = "should contain 3 to 15 character,,")
	private String name;
	@NotNull(message = "Price field is requird..")
	private Double price;
	@NotNull(message = "Quentity field is requird..")
	private Integer quantity;
}
