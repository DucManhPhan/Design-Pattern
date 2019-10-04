import RuleHandler from "./RuleHandler";
import RequestDto from "../RequestDto";
import Label from "../Label";



export default class EffectivenessAssessmentPending extends RuleHandler {

    public handle(request: RequestDto): Label {
        if(!request.hasEffectiveness)
        {  
            return request.isApproved ? Label.approvedOff() : Label.reprovedOff();
        } else {
            return super.handle(request);
        }
    }
}
