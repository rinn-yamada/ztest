using {Entity1_SRV as external} from './external/Entity1_SRV.csn';

service OnPremiseService {

    entity Entity1 as projection on external.Entity1;
    entity Entity2 as projection on external.Entity2;

}