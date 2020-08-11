import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
    providedIn: 'root'
  })
  
  export class PrediccionService {

    url = environment.api;

    constructor(private http: HttpClient) { }

    public predecir(prediccion: any) {
      return this.http.post<any>(`${this.url}/predecir`, prediccion);
    }

  }