import {Component, OnInit} from '@angular/core';
import {AnimalDto, AnimalRestEndpointService} from '../../generated';

@Component({
  selector: 'table-2',
  templateUrl: './table2.component.html',
  styleUrls: ['./table2.component.css']
})
export class Table2Component implements OnInit {
  displayedColumns: string[] = ['name', 'source', 'externalStatus', 'internalStatus'];
  dataSource: AnimalDto[] = [];
  animalRestEndpointService: AnimalRestEndpointService;

  constructor(animalRestEndpointService: AnimalRestEndpointService) {
    this.animalRestEndpointService = animalRestEndpointService;
  }

  ngOnInit(): void {
    this.animalRestEndpointService.getAllAnimals()
    .subscribe(resultArray => this.dataSource = resultArray,
      error => console.log("Error :: " + error));
  }
}
