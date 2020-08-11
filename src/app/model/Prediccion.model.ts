export class Prediccion {
    embarazos: number;
    glucosa: number;
    presion_sanguinea: number;
    pliegue_cutaneo: number;
    insulina: number;
    indice_de_masa_corporal: number;
    pedigri_diabetes: number;
    edad: number;
    f_de_diagnostico_month: String;
    f_diagnostico_day_of_month: number;
    f_diagnostico_day_of_week: String;
}

export class PrediccionResponse {
    creator: String;
    dataset: String;
    model: String;
    name: String;
    objective_field_name: String;
    output: String;
    probabilities: [];
    probability: number;
    resource: String;
    task: String
}