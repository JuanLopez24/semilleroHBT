import { Component, OnInit } from '@angular/core';

import{personaDTO} from './modelo/personaDTO'
@Component({
  selector: 'app-apoyo',
  templateUrl: './apoyo.component.html'
})
export class ApoyoComponent implements OnInit {
	persona:personaDTO;
	personas:personaDTO[];
	
	public mostrarFormulario:boolean;

  constructor() { }

  ngOnInit() {
  this.persona={
  	id: '0',
	nombre: '',
	apellido: '',
	tipoIdentificacion: '',
	numeroIdentificacion: '',
	mayorEdad:false,//checkbox
  sexo:'',//radiobutton
  };
  this.personas=[];
  this.mostrarFormulario=true;
  }
  mostrar(){
  
  }
  ocultar(){
  
  }
  guardar(){
  this.personas.push(this.persona);
  
  }
  borrar(){
  
  }

}
