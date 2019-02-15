package com.mzbloc.demo.sample105.interceptor;

import com.mzbloc.springboot.cxf.soap.param.ClientRequestParamVo;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;
import java.util.List;

/**
 * Created by tanxw on 2019/2/1.
 */
public class ClientLoginInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

    private ClientRequestParamVo clientRequestParamVo;

    public ClientLoginInterceptor(ClientRequestParamVo clientRequestParamVo) {
        super(Phase.PREPARE_SEND);
        this.clientRequestParamVo = clientRequestParamVo;
    }
    @Override
    public void handleMessage(SoapMessage soap) throws Fault {
        List<Header> headers = soap.getHeaders();
        Document doc = DOMUtils.createDocument();
        Element auth = doc.createElement("authrity");
        Element username = doc.createElement("username");
        Element password = doc.createElement("password");
        username.setTextContent(clientRequestParamVo.getUsername());
        password.setTextContent(clientRequestParamVo.getPassword());
        auth.appendChild(username);
        auth.appendChild(password);
        headers.add(0, new Header(new QName("tiamaes"),auth));
    }
}