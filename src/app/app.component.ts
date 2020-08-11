import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { PrediccionService } from "./service/prediccion-service";
import { Prediccion, PrediccionResponse } from './model/Prediccion.model';

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {
  constructor(
    private fb: FormBuilder,
    private prediccionService: PrediccionService
  ) {}

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

  validateForm: FormGroup;
  isVisible = false;
  isOkLoading = false;
  value?: string;
  model: Prediccion;
  respuestaPred: PrediccionResponse;

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
    
      this.prediccionService.predecir(this.model).subscribe(data => {
        this.respuestaPred = data;
        console.log('RETURN :', this.respuestaPred);
      });
    }
  }

  listOfData: Person[] = [
    {
      key: "1",
      name: "John Brown Ascencio",
      age: 32,
      address: "New York No. 1 Lake Park",
    },
    {
      key: "2",
      name: "Jim Green",
      age: 42,
      address: "London No. 1 Lake Park",
    },
    {
      key: "3",
      name: "Joe Black",
      age: 32,
      address: "Sidney No. 1 Lake Park",
    },
  ];

  submitForm(): void {
    console.log("Datos recividos :", this.validateForm.value.userName);
  }

  

  showModal(): void {
    this.isVisible = true;
  }

  handleOk(): void {
    this.isOkLoading = true;
    setTimeout(() => {
      this.isVisible = false;
      this.isOkLoading = false;
    }, 3000);
  }

  handleCancel(): void {
    this.isVisible = false;
  }
}

interface Person {
  key: string;
  name: string;
  age: number;
  address: string;
}
