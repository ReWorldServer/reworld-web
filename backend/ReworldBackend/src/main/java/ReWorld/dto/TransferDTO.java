package ReWorld.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferDTO {

    private Long id;
    private String userName;
    private Double totalPrice;

    private ProductDTO productDTO; //relacion que tiene con el dto de product importa el product id
}
