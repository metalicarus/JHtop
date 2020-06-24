package org.hobgoblin.processos;

import java.util.ArrayList;

public class Status {
	private ArrayList<ChaveValor> chaves = new ArrayList<ChaveValor>();

    public ArrayList<ChaveValor> getChaveValor() {
    	return this.chaves;
    }
    
    public ChaveValor getChaveValorIndex(int index) {
    	return this.chaves.get(index);
    }
    
    public void addChaveValor(ChaveValor cv) {
    	this.chaves.add(cv);
    }

}
