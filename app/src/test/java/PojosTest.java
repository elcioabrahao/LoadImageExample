import org.junit.Test;

import br.com.qpainformatica.qpabbb.domain.model.Page;
import br.com.qpainformatica.qpabbb.domain.model.Player;
import br.com.qpainformatica.qpabbb.domain.model.Shot;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by eabrahao on 28/09/15.
 */
public class PojosTest {

    @Test
    public void testePagePojo(){

        Page page = new Page();
        page.setPage(1);

        assertThat(page.getPage(), is(1));

    }

    @Test
    public void testeShotPojo(){

        Shot shot = new Shot();
        shot.setDescription("TESTE");

        assertThat(shot.getDescription(), is("TESTE"));

    }

    @Test
    public void testePlayerPojo(){

        Player player = new Player();
        player.setName("TESTE");

        assertThat(player.getName(), is("TESTE"));

    }


}
