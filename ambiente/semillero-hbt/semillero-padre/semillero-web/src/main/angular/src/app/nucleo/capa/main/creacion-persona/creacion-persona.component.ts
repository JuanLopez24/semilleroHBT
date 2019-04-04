import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-creacion-persona',
  templateUrl: './creacion-persona.component.html',
  styleUrls: ['./creacion-persona.component.css']
})
export class CreacionPersonaComponent implements OnInit {
	
	tipo:String="Pasaporte";
	nombre:String="Carlos";
	apellido:String="cardona";
	cedula:String="1098312099";
	id:String="1";
  constructor() { }

  ngOnInit() {
  }

}
