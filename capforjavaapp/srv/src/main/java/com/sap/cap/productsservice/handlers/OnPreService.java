package com.sap.cap.productsservice.handlers;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sap.cds.services.handler.annotations.ServiceName;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.Result;
import com.sap.cds.ql.Select;
import com.sap.cds.ql.cqn.CqnSelect;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.cds.CdsService;

import cds.gen.entity1_srv.*;

@Component
@ServiceName("OnPreService")
public class OnPreService implements EventHandler {
    @Autowired
    @Qualifier(Entity1Srv_.CDS_NAME)
    CqnService remote1;

    @On(event = CdsService.EVENT_READ, entity = Entity1_.CDS_NAME)
    public void onRead(CdsReadEventContext context) {
        CqnSelect selectQuery = Select.from(Entity1_.CDS_NAME);
        Result result = remote1.run(selectQuery);
        context.setResult(result);
    }
    
}
