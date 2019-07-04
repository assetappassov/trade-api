import ApiService from '../api.service'

export const TradeService = {
    validate (payload) {
        return ApiService.post(`/trades/validate`, payload);
    }
};

export default TradeService
