/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.rainstone.model;

/**
 *
 * @author Eduardo Albertini
 */
public class VirtualMachine {
    
    private long id;
    private String nome;
    private int masterVM;
    private int slaveVM;
    private String memoriaTotal;
    private String memoriaUsada;
    private String CPUSpeed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMasterVM() {
        return masterVM;
    }

    public void setMasterVM(int masterVM) {
        this.masterVM = masterVM;
    }

    public int getSlaveVM() {
        return slaveVM;
    }

    public void setSlaveVM(int slaveVM) {
        this.slaveVM = slaveVM;
    }

    public String getMemoriaTotal() {
        return memoriaTotal;
    }

    public void setMemoriaTotal(String memoriaTotal) {
        this.memoriaTotal = memoriaTotal;
    }

    public String getMemoriaUsada() {
        return memoriaUsada;
    }

    public void setMemoriaUsada(String memoriaUsada) {
        this.memoriaUsada = memoriaUsada;
    }

    public String getCPUSpeed() {
        return CPUSpeed;
    }

    public void setCPUSpeed(String CPUSpeed) {
        this.CPUSpeed = CPUSpeed;
    }

    @Override
    public String toString() {
        return id + " - " + memoriaTotal + " : " + memoriaUsada + " : "  + CPUSpeed;
    }
}
