import TrainingEffectiveness from "../legacy-code/TrainningEffectiveness";
import TrainingEvaluation from "../legacy-code/TraniningEvaluation";
import RequestDto from "./RequestDto";
import CriteriaHasEvaluation from "./criteria/CriteriaHasEvaluation";
import EffectivenessAssessmentPending from "./criteria/EffectivenessAssessmentPending";
import NewItem from "./criteria/NewItem";



export default class RefactoredWebformsComponentCodeBehind {

    trainingEffectiveness: TrainingEffectiveness[] = [
        new TrainingEffectiveness("MPD_0001", 0),
        new TrainingEffectiveness("LHPT_0010", 1),
        new TrainingEffectiveness("PNDT_0011", 1),
        new TrainingEffectiveness("MP_0020", 0)
    ];

    trainingEvaluations: TrainingEvaluation[] = [
        new TrainingEvaluation(true, "MPD_0001", "0001", true),
        new TrainingEvaluation(true, "LHPT_0010", "0011", true),
        new TrainingEvaluation(true, "PNDT_0011", "0101", true)
    ];

    public GetClass(code: String, approve: boolean): String {

        const request = new RequestDto(code, approve, this.trainingEvaluations, this.trainingEffectiveness);

        if (request.criteriaHasEvaluation)
        {
            return request.evaluation.hasEvaluation
                ? request.isApproved
                    ? request.evaluation.isApproved
                        ? "approvedOn"
                        : "approvedOff"
                    : !request.evaluation.isApproved
                        ? "reprovedOn"
                        : "reprovedOff"
                : request.isApproved
                    ? "approvedOff"
                    : "reprovedOff";
        }

        if (request.isNew) return approve ? "approvedOff" : "reprovedOff";

        if (!request.hasEffectiveness) return approve ? "approvedOff" : "reprovedOff";

        switch (request.effectiveness.isEffective)
        {
            case 0:
                return approve ? "approvedOff" : "reprovedOn";
            case 1:
                return approve ? "approvedOn" : "reprovedOff";
            default:
                return approve ? "approvedOff" : "reprovedOff";
        }
    }

    public GetClass_Refactor(code: String, approve: boolean): String {
        var request = new RequestDto(code, approve, this.trainingEvaluations, this.trainingEffectiveness);

        const chain = new CriteriaHasEvaluation();    
        chain
            .setNext(new EffectivenessAssessmentPending())
            .setNext(new NewItem())
            .setNext(new CriteriaHasEvaluation());

        var label = chain.handle(request);

        return label.value;
    }
}