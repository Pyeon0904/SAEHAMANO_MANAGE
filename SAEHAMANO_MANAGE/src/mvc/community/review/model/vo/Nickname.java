/*210423 16:15 κΉμμ */
package mvc.community.review.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nickname {
	private int nick_sequence;
	
	private String nickname;
	
	private String password;
}
