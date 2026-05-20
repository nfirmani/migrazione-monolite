import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';


// Ho rimosso RouterOutlet per eliminare il Warning

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule], // Rimosso RouterOutlet anche da qui
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit { // <-- ECCO IL FIX: Cambiato da AppComponent ad App
  cittadini: any[] =[];
  nuovoCittadino = { nome: '', cognome: '', codiceFiscale: '' };

  // constructor(private http: HttpClient) {}
  // Aggiungi private cdr: ChangeDetectorRef
constructor(private http: HttpClient, private cdr: ChangeDetectorRef) {}

  ngOnInit() {
    this.caricaCittadini();
  }

  caricaCittadini() {
    // Chiama la GET di WildFly
    this.http.get<any[]>('/anagrafe/api/cittadini').subscribe(data => {
      this.cittadini = data;
    });
  }

  // aggiungiCittadino() {
  //   // Chiama la POST di WildFly
  //   console.log("Inviando al backend:", this.nuovoCittadino);
  //   this.http.post('/anagrafe/api/cittadini', this.nuovoCittadino).subscribe(() => {
  //     this.caricaCittadini(); // Ricarica la tabella
  //     this.nuovoCittadino = { nome: '', cognome: '', codiceFiscale: '' }; // Svuota i campi
  //   });
  // }

// aggiungiCittadino() {
//   // Passiamo <any> per tipizzare la risposta di ritorno
//   this.http.post<any>('/anagrafe/api/cittadini', this.nuovoCittadino).subscribe({
//     next: (nuovoRecord) => {
//       // 1. Aggiungiamo istantaneamente il record appena salvato alla lista.
//       // Usiamo lo spread operator [...] per forzare Angular ad aggiornare la vista subito.
//       this.cittadini = [...this.cittadini, nuovoRecord];

//       // 2. Svuotiamo il form
//       this.nuovoCittadino = { nome: '', cognome: '', codiceFiscale: '' };
//     },
//     error: (err) => {
//       console.error("Errore durante il salvataggio:", err);
//       alert("Si è verificato un errore nel salvataggio.");
//     }
//   });
// }


aggiungiCittadino() {
  console.log("🔴 STEP 1: Inviando al backend:", this.nuovoCittadino);

  this.http.post<any>('/anagrafe/api/cittadini', this.nuovoCittadino).subscribe({
    next: (rispostaServer) => {
      console.log("🟢 STEP 2: Dati ricevuti dal backend:", rispostaServer);

      this.cittadini = [...this.cittadini, rispostaServer];
      console.log("🔵 STEP 3: Array locale aggiornato. Elementi totali:", this.cittadini.length);

      this.nuovoCittadino = { nome: '', cognome: '', codiceFiscale: '' };

      // IL FIX MAGICO: Diciamo ad Angular "Ehi, ridisegna subito l'HTML!"
      this.cdr.detectChanges(); 
    },
    error: (err) => {
      console.error("❌ ERRORE IMPREVISTO:", err);
    }
  });
}




}