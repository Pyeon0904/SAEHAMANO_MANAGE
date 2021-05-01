package mvc.login.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
	
	private int no;
	
	private String id;
	
	private String password;
		
	private String status;
}
