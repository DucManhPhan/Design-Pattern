import RuleHandler from "./RuleHandler";
import RequestDto from "../RequestDto";
import Label from "../Label";



export default class NewItem extends RuleHandler {

    public handle(request: RequestDto): Label {
        if (request.isNew) {
            return request.isApproved ? Label.approvedOff() : Label.reprovedOff();
        } else {
            return super.handle(request);
        }
    }
}