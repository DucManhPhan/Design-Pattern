import RuleHandler from "./RuleHandler";
import Label from "../Label";
import RequestDto from "../RequestDto";



export default class CriteriaHasEvaluation extends RuleHandler {
    
    public handle(request: RequestDto): Label {
        if(request.criteriaHasEvaluation)
         {
            return request.evaluation.hasEvaluation
                    ? request.isApproved
                        ? request.evaluation.isApproved
                            ? Label.approvedOn()
                            : Label.approvedOff()
                        : !request.evaluation.isApproved
                            ? Label.reprovedOn()
                            : Label.reprovedOff()
                    : request.isApproved
                        ? Label.reprovedOff()
                        : Label.reprovedOff();
        } else {
            return super.handle(request);
        }
    }
}
