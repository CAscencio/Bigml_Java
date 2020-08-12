import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { PrediccionService } from "./service/prediccion-service";
import { NzMessageService } from 'ng-zorro-antd/message';
import { Prediccion, PrediccionResponse } from './model/Prediccion.model';

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {
  constructor(
    private fb: FormBuilder,
    private message: NzMessageService,
    private prediccionService: PrediccionService
  ) {}
  
  validateForm: FormGroup;
  model: Prediccion;
  respuestaPred: PrediccionResponse;

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      embarazos: [null, [Validators.required]],
      glucosa: [null, [Validators.required]],
      presion_sanguinea: [null, [Validators.required]],
      pliegue_cutaneo: [null, [Validators.required]],
      insulina: [null, [Validators.required]],
      indice_de_masa_corporal: [null, [Validators.required]],
      pedigri_diabetes: [null, [Validators.required]],
      edad: [null, [Validators.required]],
      f_de_diagnostico_month: [null, [Validators.required]],
      f_diagnostico_day_of_month: [null, [Validators.required]],
      f_diagnostico_day_of_week: [null, [Validators.required]],
    });
  }

  predecir() {
    if(this.validateForm.valid) {
      this.model = {
        "embarazos": this.validateForm.get('embarazos').value,
        "glucosa": this.validateForm.get('glucosa').value,
        "presion_sanguinea": this.validateForm.get('presion_sanguinea').value,
        "pliegue_cutaneo": this.validateForm.get('pliegue_cutaneo').value,
        "insulina": this.validateForm.get('insulina').value,
        "indice_de_masa_corporal": this.validateForm.get('indice_de_masa_corporal').value,
        "pedigri_diabetes": this.validateForm.get('pedigri_diabetes').value,
        "edad": this.validateForm.get('edad').value,
        "f_de_diagnostico_month": this.validateForm.get('f_de_diagnostico_month').value,
        "f_diagnostico_day_of_month": this.validateForm.get('f_diagnostico_day_of_month').value,
        "f_diagnostico_day_of_week": this.validateForm.get('f_diagnostico_day_of_week').value
    };    
    
    this.message.success('Prediccón Enviada correctamente');

      this.prediccionService.predecir(this.model).subscribe(data => {
        this.respuestaPred = data;
        console.log('RETURN :', this.respuestaPred);
        this.validateForm.reset();
      });
    }
  }
}