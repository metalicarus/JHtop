package org.hobgoblin.pusher;

import java.util.Collections;

import org.hobgoblin.acessos.Acesso;
import org.hobgoblin.processos.Processo;

import com.pusher.rest.Pusher;

public class EnvioPusher {
	private Acesso ac;
    private Pusher p;

    public EnvioPusher() {
        ac = new Acesso();
        p = new Pusher(ac.getPusherAppId(), ac.getPusherKey(), ac.getPusherSecret());
        p.setCluster("us2");
        p.setEncrypted(true);
    }

    public void enviarProcesso(Processo processo) {
        this.p.trigger("processo", "novo-processo", Collections.singletonMap("processo", processo));
    }
}
