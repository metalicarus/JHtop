package org.hobgoblin.processos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.hobgoblin.pusher.EnvioPusher;

public class Processamento {
	
	private final String local = "/proc";
    private EnvioPusher ep = new EnvioPusher();

    public Processamento() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        Runnable task = new Runnable() {
            public void run() {
                Processamento.this.processos();
            }
        };
        ses.scheduleAtFixedRate(task, 0, 240, TimeUnit.SECONDS);
    }
    private Boolean validaPid(String pid) {
        try {
            Integer.parseInt(pid);
            return true;
        }catch(Exception e) {
            return false;
        }
    }
    private void processos() {
        File diretorios = new File(this.local);
        for(File f : diretorios.listFiles()) {
            if(this.validaPid(f.getName()))
                this.processo(f.getName());
        }
    }
    private void processo(String processoNumero) {
        Processo processo = new Processo();
        processo.setCommand(
                this.lerCommand(new File(this.local+"/"+processoNumero+"/comm"))
        );
        processo.setStatus(
                this.statusProcesso(new File(this.local+"/"+processoNumero+"/status"))
        );
        this.ep.enviarProcesso(processo);
    }
    private Command lerCommand(File command) {
        try {
            @SuppressWarnings("resource")
            BufferedReader buff = new BufferedReader(new FileReader(command));
            String st;
            Command c = new Command();
            while((st = buff.readLine())!= null) {
                return c.factory(st);
            }

        }catch (Exception e) {

        }
        return null;
    }
    private Status statusProcesso(File status) {
        try {
            @SuppressWarnings("resource")
            BufferedReader buff = new BufferedReader(new FileReader(status));
            String st;
            Status s = new Status();
            ChaveValor cv = new ChaveValor();
            while((st = buff.readLine())!= null) {
                s.addChaveValor(
                		cv.factory(st.split(":")[0], st.split(":")[1])
                );
            }
            return s;
        } catch (Exception e) {
        }
        return null;
    }
}
