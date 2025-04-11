import {Injectable} from '@angular/core';

@Injectable({ providedIn: 'root' })
export class AuthService {
  getToken(): string | null {
    return localStorage.getItem('token');
  }

  isLoggedIn(): boolean {
    const token = this.getToken();
    // You can add additional token expiry checks here
    return !!token;
  }

  logout(): void {
    localStorage.removeItem('token');
  }
}
