import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';



@Component({
  selector: 'app-kolcsonzesek',
  templateUrl: './kolcsonzesek.component.html',
  styleUrls: ['./kolcsonzesek.component.css']
})
export class KolcsonzesekComponent implements OnInit {
  displayedColumns: string[] = ['iro', 'mufaj', 'cim', 'mentes', 'torles'];
  dataSource: any[] = [];
  errorMessage: string = '';

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<any[]>('http://localhost:3001/Kolcsonzesek').subscribe(
      (data: any[]) => {
        this.dataSource = data;
      },
      (error) => {
        this.errorMessage = error.message;
      }
    );
  }

  onButtonClick(): void {
    console.log('A gombra kattintottak!');
    
  }
}