/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.rainstone;

import br.edu.utfpr.cm.rainstone.model.VirtualMachine;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miray
 */
@WebServlet(name = "Initializer", urlPatterns = {"/Initializer"})
public class Initializer extends HttpServlet {

    private int qtdeHosts = 2;
    private List<VirtualMachine> listVMs;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        listVMs = new ArrayList<VirtualMachine>();

        try {
            String sistemaOperacional = System.getProperty("os.name");

//            if (!sistemaOperacional.contains("nix")) {
//                //Executar ação caso não for linux-based
//            }

            System.out.println(sistemaOperacional);
//            Runtime.getRuntime().exec("one start");
//            Process procListHost = Runtime.getRuntime().exec("onehost list");
//            procListHost.waitFor();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(procListHost.getInputStream()));
            BufferedReader reader = new BufferedReader(new FileReader("D:\\TCC\\onelist.txt"));
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    System.out.println(line);
                    line = line.trim();
                    String idVM = line.split(" ")[0];

//                  Process procShowHost = Runtime.getRuntime().exec("onehost show " + idVM);
//                  procShowHost.waitFor();
//                  BufferedReader br = new BufferedReader(new InputStreamReader(procShowHost.getInputStream()));
                    BufferedReader br = new BufferedReader(new FileReader("D:\\TCC\\oneshow1.txt"));

                    String l = br.readLine();
                    VirtualMachine vm = new VirtualMachine();
                    vm.setId(Long.parseLong(idVM));

                    while (l != null) {
                        l = br.readLine();
                        if (l != null) {
                            System.out.println(l);
                            if (l.startsWith("NAME")) {
                                l = l.replace(" ", "");
                                vm.setNome(l.split(":")[1]);
                            }
                            if (l.startsWith("TOTAL MEM")) {
                                String memTotal = l.replace(" ", "");
                                memTotal = memTotal.split(":")[1];
                                memTotal += "b";
                                vm.setMemoriaTotal(memTotal);
                            }
                            if (l.startsWith("USED MEM (REAL)")) {
                                String memUsada = l.replace(" ", "");
                                memUsada = memUsada.split(":")[1];
                                memUsada += "b";
                                vm.setMemoriaUsada(memUsada);

                            }
                            if (l.startsWith("CPUSPEED")) {
                                l = l.replace("\"", "");
                                vm.setCPUSpeed(l.split("=")[1]);
                            }
                        }
                    }
                    System.out.println(vm.toString());
                    listVMs.add(vm);
                }
            }

            qtdeHosts = listVMs.size() + 1;


            request.getSession().invalidate();
            request.getSession().setAttribute("qtdeHosts", qtdeHosts);
            request.getSession().setAttribute("listHosts", listVMs);

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
