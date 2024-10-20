package com.nourcine.backend.auth;



public class AuthenticationResponse {
    private String token;

    public static AuthenticationResponseBuilder builder() {
        return new AuthenticationResponseBuilder();
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AuthenticationResponse)) {
            return false;
        } else {
            AuthenticationResponse other = (AuthenticationResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$token = this.getToken();
                Object other$token = other.getToken();
                if (this$token == null) {
                    if (other$token != null) {
                        return false;
                    }
                } else if (!this$token.equals(other$token)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AuthenticationResponse;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $token = this.getToken();
        result = result * 59 + ($token == null ? 43 : $token.hashCode());
        return result;
    }

    public String toString() {
        return "AuthenticationResponse(token=" + this.getToken() + ")";
    }

    public AuthenticationResponse(final String token) {
        this.token = token;
    }

    public AuthenticationResponse() {
    }

    public static class AuthenticationResponseBuilder {
        private String token;

        AuthenticationResponseBuilder() {
        }

        public AuthenticationResponseBuilder token(final String token) {
            this.token = token;
            return this;
        }

        public AuthenticationResponse build() {
            return new AuthenticationResponse(this.token);
        }

        public String toString() {
            return "AuthenticationResponse.AuthenticationResponseBuilder(token=" + this.token + ")";
        }
    }
}
