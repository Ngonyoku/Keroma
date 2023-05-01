package ke.co.ngonyoku.keroma.Keroma.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;


    @Column(nullable = false)
    private String fileName;

    public Image(String url, String fileName, MenuItem menuItem) {
        this.url = url;
        this.fileName = fileName;
        this.menuItem = menuItem;
    }

    public Image(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }
}
