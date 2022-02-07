import http from '../http-common'

class CustomerDataService {
    getAllCustomers() {
        return http.get("/")
    }

    getFilteredCustomers(country, phoneState) {
        return http.get(`/filter?country=${country}&phone_state=${phoneState}`)
    }
}

export default new CustomerDataService()