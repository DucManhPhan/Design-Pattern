import  TrainingEffectiveness from "./TrainningEffectiveness";
import TrainingEvaluation from "./TraniningEvaluation";
import IEntity from "./IEntity";




export default class WebformsComponentCodeBehind
{
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

        // Don't bother these
        const evaluation: TrainingEvaluation = this.trainingEvaluations.filter(x => x.employeeCode === code.split('_')[0] 
                                                                                 && x.criteriaCode === code.split('_')[1])[0];
        const criteriaHasEvaluation = evaluation != null;
        const isNew = code.split('_')[1] == IEntity.newCode;
        const effectiveness = this.trainingEffectiveness.filter(x => x.employeeCode === code.split('_')[0])[0];
        const hasEffectiveness = effectiveness != null;
        
        // We'll refactor this
        if (criteriaHasEvaluation)
        {
            return evaluation.hasEvaluation
                ? approve
                    ? evaluation.isApproved
                        ? "approvedOn"
                        : "approvedOff"
                    : !evaluation.isApproved
                        ? "reprovedOn"
                        : "reprovedOff"
                : approve
                    ? "approvedOff"
                    : "reprovedOff";
        }
        
        if (!hasEffectiveness) return approve ? "approvedOff" : "reprovedOff";

        if (isNew) return "approvedOff";

        switch (effectiveness.isEffective)
        {
            case 0:
                return approve ? "approvedOff" : "reprovedOn";
            case 1:
                return approve ? "approvedOn" : "reprovedOff";
            default:
                return approve ? "approvedOff" : "reprovedOff";
        }
    }
}