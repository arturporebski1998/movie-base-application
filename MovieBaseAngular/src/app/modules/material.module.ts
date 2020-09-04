import { NgModule } from '@angular/core';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatListModule } from '@angular/material/list'
import { MatButtonModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDividerModule } from '@angular/material/divider';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { MatCardModule } from '@angular/material/card';
const MaterialComponents = [
  MatButtonToggleModule,
  MatInputModule,
  MatFormFieldModule,
  MatSelectModule,
  MatListModule,
  MatButtonModule,
  BrowserAnimationsModule,
  BrowserModule,
  MatDividerModule,
  MatToolbarModule,
  FormsModule,
  ReactiveFormsModule,
  MatCardModule
];

@NgModule({
  imports: [MaterialComponents],
  exports: [MaterialComponents]
})
export class MaterialModule { }
