import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-offers',
  templateUrl: './kolcsonzok.component.html',
  styleUrls: ['./kolcsonzok.component.css']
})
export class KolcsonzokComponent implements OnInit{
  displayedColumns: string[] = ['nev', 'szulIdo', 'kolcsonzesek'];
  dataSource: any[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<any[]> ('http://localhost:3001/Kolcsonzok').subscribe(data => {
      this.dataSource = data;
    });
  }

  onKolcsonzesekClick(row: any) {
   
    console.log('Kölcsönzések gombra kattintva:', row);
  }

}