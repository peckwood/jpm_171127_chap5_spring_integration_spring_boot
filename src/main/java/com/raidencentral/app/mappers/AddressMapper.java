package com.raidencentral.app.mappers;

import com.raidencentral.app.domain.Address;

/**
 * @author Siva
 *
 */
public interface AddressMapper
{
	Address findAddressById(Integer id);
}
