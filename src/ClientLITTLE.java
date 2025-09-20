
    public class ClientLITTLE extends Client {
        public ClientLITTLE(int ClientId, String lastName, String firstName, String phone, String email){
            super(ClientId, lastName, firstName, phone, email);
        }

        // Конструктор краткой версии
        public ClientLITTLE(Client client) {
            super(client.getClientId(), client.getLastName(), client.getFirstName(), client.getPhone(),client.getEmail());
        }

        @Override
        public String toString() {
            return toShortString(); // вывод краткой версии
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ClientLITTLE)) return false;
            ClientLITTLE other = (ClientLITTLE) o;
            return this.toShortString().equals(other.toShortString());
        }
        @Override
        public int hashCode() {
            return toShortString().hashCode();
        }
    }